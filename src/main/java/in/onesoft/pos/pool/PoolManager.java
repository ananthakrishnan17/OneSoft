package in.onesoft.pos.pool;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PoolManager {

    // DB key → HikariPool
    // ConcurrentHashMap — thread safe
    private static final Map<String, HikariDataSource> pools = new ConcurrentHashMap<>();

    /**
     * dbKey கொடு → DSLContext கிடைக்கும்
     * Pool இல்லன்னா புதுசா create பண்ணும்
     *
     * dbKey example: "DB-1", "DB-2"
     */
    public static DSLContext getContext(String dbKey,
            String jdbcUrl,
            String username,
            String password) {

        // Pool already இருக்கா?
        HikariDataSource ds = pools.get(dbKey);

        if (ds == null) {
            // இல்லன்னா புதுசா create பண்ணு
            synchronized (PoolManager.class) {
                // Double check — two threads same time வந்திருந்தா
                ds = pools.get(dbKey);
                if (ds == null) {
                    ds = createPool(dbKey, jdbcUrl, username, password);
                    pools.put(dbKey, ds);
                }
            }
        }

        return DSL.using(ds, SQLDialect.POSTGRES);
    }

    /**
     * புது HikariPool create பண்ணு
     * Max 20 connections per DB
     */
    private static HikariDataSource createPool(String dbKey,
            String jdbcUrl,
            String username,
            String password) {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(username);
        config.setPassword(password);
        config.setMaximumPoolSize(20); // max 20 live connections
        config.setMinimumIdle(2); // minimum 2 always ready
        config.setConnectionTimeout(30000); // 30 seconds wait
        config.setPoolName("Pool-" + dbKey);

        System.out.println("[PoolManager] Creating pool for: " + dbKey);
        return new HikariDataSource(config);
    }

    /**
     * எத்தனை pools active-ஆ இருக்குன்னு பாக்க
     */
    public static int activePoolCount() {
        return pools.size();
    }

    /**
     * App shutdown-ல எல்லா pools-ஐயும் close பண்ணு
     */
    public static void closeAll() {
        pools.forEach((key, ds) -> {
            if (!ds.isClosed()) {
                ds.close();
                System.out.println("[PoolManager] Closed pool: " + key);
            }
        });
        pools.clear();
    }
}