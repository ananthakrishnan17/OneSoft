package in.onesoft.pos.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {

    private static final JedisPool pool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        config.setMinIdle(2);
        config.setTestOnBorrow(true);

        // Read from Environment Variables with local fallbacks
        String host = System.getenv("REDIS_HOST");
        if (host == null || host.trim().isEmpty()) {
            host = "localhost"; // Default for local Tomcat testing
        }

        int port = 6379;
        String portEnv = System.getenv("REDIS_PORT");
        if (portEnv != null && !portEnv.trim().isEmpty()) {
            port = Integer.parseInt(portEnv.trim());
        }

        // Assuming no password for local dev, but you can easily add auth here later
        pool = new JedisPool(config, host, port);
        System.out.println("[Redis] Connected to Redis at " + host + ":" + port);
    }

    // Get a connection from the pool
    public static Jedis getResource() {
        return pool.getResource();
    }

}