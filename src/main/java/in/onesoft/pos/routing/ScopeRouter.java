package in.onesoft.pos.routing;

import in.onesoft.pos.db.Database;
import in.onesoft.pos.id.IdGenerator;
import in.onesoft.pos.pool.PoolManager;
import org.jooq.DSLContext;
import org.jooq.Record;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ScopeRouter {

    // scopeId → DB info cache (memory)
    // DB hit தவிர்க்க
    private static final Map<String, DbInfo> scopeCache = new ConcurrentHashMap<>();

    /**
     * ID கொடு → correct DB-ஓட DSLContext கிடைக்கும்
     *
     * Example:
     * route("0000001382916475820")
     * → scopeId = "0000001"
     * → DB-1 ஓட DSLContext return
     */
    public static DSLContext route(String id) {
        String scopeId = IdGenerator.extractScopeId(id);
        return routeByScopeId(scopeId);
    }

    /**
     * scopeId கொடு → correct DB DSLContext
     */
    public static DSLContext routeByScopeId(String scopeId) {

        // Memory cache-ல இருக்கா?
        DbInfo dbInfo = scopeCache.get(scopeId);

        if (dbInfo == null) {
            // இல்லன்னா Central DB-ல query பண்ணு
            dbInfo = loadFromDb(scopeId);
            if (dbInfo == null) {
                throw new RuntimeException(
                        "No DB mapping found for scopeId: " + scopeId);
            }
            // cache-ல save பண்ணு
            scopeCache.put(scopeId, dbInfo);
        }

        // PoolManager → correct DB connection
        return PoolManager.getContext(
                dbInfo.dbKey,
                dbInfo.jdbcUrl,
                dbInfo.username,
                dbInfo.password);
    }

    /**
     * Central DB-ல scope_registry table query பண்ணு
     */
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

    /**
     * Scope cache clear பண்ணு
     * (DB config மாத்தும்போது call பண்ணு)
     */
    public static void clearCache(String scopeId) {
        scopeCache.remove(scopeId);
    }

    public static void clearAllCache() {
        scopeCache.clear();
    }

    // DB connection info holder
    private static class DbInfo {
        String dbKey;
        String jdbcUrl;
        String username;
        String password;
    }
}