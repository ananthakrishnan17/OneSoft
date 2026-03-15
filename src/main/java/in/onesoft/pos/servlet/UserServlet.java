package in.onesoft.pos.servlet;

import in.onesoft.pos.model.User;
import in.onesoft.pos.repository.UserRepository;
import in.onesoft.pos.util.JsonUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

/**
 * GET /api/users?companyId=xxx — company-ஓட users list
 * GET /api/users/{id} — ஒரு user
 * POST /api/users — புது user create
 */
@WebServlet("/api/users/*")
public class UserServlet extends HttpServlet {

    private final UserRepository repo = new UserRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            // GET /api/users?companyId=...
            String companyId = req.getParameter("companyId");
            if (companyId == null) {
                JsonUtil.error(res, 400, "companyId parameter required");
                return;
            }
            JsonUtil.send(res, 200, repo.findByCompany(companyId));

        } else {
            // GET /api/users/{id}
            String id = pathInfo.substring(1);
            User user = repo.findById(id);

            if (user == null) {
                JsonUtil.error(res, 404, "User not found");
            } else {
                user.passwordHash = null; // hash-ஐ expose பண்ண வேண்டாம்
                JsonUtil.send(res, 200, user);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        User user = JsonUtil.parse(req, User.class);
        User created = repo.create(user);
        JsonUtil.send(res, 201, created);
    }
}