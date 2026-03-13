package in.onesoft.pos.servlet;

import in.onesoft.pos.db.Database;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/api/health")
public class HealthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        String dbStatus;
        try {
            Database.ctx().fetch("SELECT 1");
            dbStatus = "UP";
        } catch (Exception e) {
            dbStatus = "DOWN: " + e.getMessage();
        }

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(
                "{\"app\":\"Onesoft POS\",\"db\":\"" + dbStatus + "\"}");
    }
}