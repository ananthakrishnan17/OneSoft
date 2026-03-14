package in.onesoft.pos.routing;

import in.onesoft.pos.db.Database;
import in.onesoft.pos.id.IdGenerator;
import in.onesoft.pos.pool.PoolManager;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ScopeRouter {

    private static final Map<String, DbInfo> scopeCache = new ConcurrentHashMap<>();

    public static DSLContext route(String id) {
        String scopeId = IdGenerator.extractScopeId(id);
        return routeByScopeId(scopeId);
    }


    public static DSLContext routeByScopeId(String scopeId) {

        DbInfo dbInfo = scopeCache.get(scopeId);

        if (dbInfo == null) {
        
            dbInfo = loadFromDb(scopeId);
            if (dbInfo == null) {
                throw new RuntimeException(
                        "No DB mapping found for scopeId: " + scopeId);
            }
        
            scopeCache.put(scopeId, dbInfo);
        }

    
        return PoolManager.getContext(
                dbInfo.dbKey,
                dbInfo.jdbcUrl,
                dbInfo.username,
                dbInfo.password);
    }


    private static DbInfo loadFromDb(String scopeId) {
        try {
            Record record = Database.ctx()
                    .select()
                    .from("scope_registry")
                    .where("scope_id = ?", scopeId)
                    .and("is_active = true")
                    .fetchOne();

            if (record == null)
                return null;

            DbInfo info = new DbInfo();
            info.dbKey = record.get("db_key", String.class);
            info.jdbcUrl = record.get("db_url", String.class);
            info.username = record.get("db_username", String.class);
            info.password = record.get("db_password", String.class);
            return info;

        } catch (Exception e) {
            throw new RuntimeException("ScopeRouter DB query failed", e);
        }
    }


    public static void clearCache(String scopeId) {
        scopeCache.remove(scopeId);
    }

    public static void clearAllCache() {
        scopeCache.clear();
    }

 
    private static class DbInfo {
        String dbKey;
        String jdbcUrl;
        String username;
        String password;
    }
}