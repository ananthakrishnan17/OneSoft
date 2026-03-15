package in.onesoft.pos.servlet;

import in.onesoft.pos.db.Database;
import in.onesoft.pos.id.IdGenerator;
import in.onesoft.pos.routing.ScopeRouter;

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

        // 2. ID Generator test
        String scopeId = IdGenerator.formatScopeId(1); // "0000001"
        String newId = IdGenerator.generate(scopeId); // 19 digit

        // 3. ScopeRouter test
        String routerStatus;
        try {
            ScopeRouter.routeByScopeId("0000001").fetch("SELECT 1");
            routerStatus = "OK - routed to DB-1";
        } catch (Exception e) {
            routerStatus = "FAILED: " + e.getMessage();
        }

        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(
                "{" +
                        "\"app\":\"Onesoft POS\"," +
                        "\"db\":\"" + dbStatus + "\"," +
                        "\"sampleId\":\"" + newId + "\"," +
                        "\"scopeRouter\":\"" + routerStatus + "\"" +
                        "}");
    }
}