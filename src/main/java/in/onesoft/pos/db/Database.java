package in.onesoft.pos.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

public class Database {

    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");

        // Read from Environment Variables with fallbacks
        String dbUrl = System.getenv("DB_URL");
        if (dbUrl == null || dbUrl.trim().isEmpty()) {
            dbUrl = "jdbc:postgresql://18.60.112.102:5432/one";
        }

        String dbUser = System.getenv("DB_USER");
        if (dbUser == null || dbUser.trim().isEmpty()) {
            dbUser = "pgsql";
        }

        String dbPass = System.getenv("DB_PASS");
        if (dbPass == null || dbPass.trim().isEmpty()) {
            dbPass = "tofze1-gEjmaf-mugdes";
        }

        config.setJdbcUrl(dbUrl);
        config.setUsername(dbUser);
        config.setPassword(dbPass);

        config.setMaximumPoolSize(20);
        config.setMinimumIdle(2);
        config.setConnectionTimeout(30000);
        config.setPoolName("POS-Main-Pool");

        dataSource = new HikariDataSource(config);

        // Extract host/db for clean logging without exposing credentials
        String cleanUrl = dbUrl.replace("jdbc:postgresql://", "");
        System.out.println("[Database] Connected to PostgreSQL: " + dbUser + "@" + cleanUrl);
    }

    public static DSLContext ctx() {
        return DSL.using(dataSource, SQLDialect.POSTGRES);
    }

    public static void close() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
            System.out.println("[Database] Connection pool closed");
        }
    }
}
