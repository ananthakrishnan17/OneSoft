package in.onesoft.pos.servlet;

import in.onesoft.pos.db.Database;
import in.onesoft.pos.util.RedisUtil;
import redis.clients.jedis.Jedis;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/api/health")
public class HealthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        // 1. DB check
        String dbStatus;
        try {
            Database.ctx().fetch("SELECT 1");
            dbStatus = "UP";
        } catch (Exception e) {
            dbStatus = "DOWN: " + e.getMessage();
        }

        // 2. Redis check
        String redisStatus;
        try (Jedis jedis = RedisUtil.getResource()) {
            redisStatus = ("PONG".equals(jedis.ping())) ? "UP" : "DOWN: Ping failed";
        } catch (Exception e) {
            redisStatus = "DOWN: " + e.getMessage();
        }

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(
                "{" +
                        "\"app\":\"Onesoft POS\"," +
                        "\"db\":\"" + dbStatus + "\"," +
                        "\"redis\":\"" + redisStatus + "\"" +
                        "}");
    }
}