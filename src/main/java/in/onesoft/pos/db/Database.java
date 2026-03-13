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
        config.setDriverClassName("org.postgresql.Driver"); // ← இதை add பண்ணு
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/onesoft_db");
        config.setUsername("onesoft");
        config.setPassword("onesoft123");
        config.setMaximumPoolSize(20);
        dataSource = new HikariDataSource(config);
    }

    public static DSLContext ctx() {
        return DSL.using(dataSource, SQLDialect.POSTGRES);
    }
}