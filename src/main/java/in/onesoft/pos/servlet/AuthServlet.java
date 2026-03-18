package in.onesoft.pos.servlet;

import in.onesoft.pos.dto.LoginRequest;
import in.onesoft.pos.model.User;
import in.onesoft.pos.repository.UserRepository;
import in.onesoft.pos.util.JsonUtil;
import in.onesoft.pos.util.JwtUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.util.Map;

@WebServlet("/api/auth/login")
public class AuthServlet extends HttpServlet {

    private final UserRepository userRepo = new UserRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        LoginRequest loginReq = JsonUtil.parse(req, LoginRequest.class);

        if (loginReq.companyId == null || loginReq.username == null || loginReq.password == null) {
            JsonUtil.error(res, 400, "companyId, username, and password are required");
            return;
        }

        User user = userRepo.findByUsername(loginReq.companyId, loginReq.username);

        if (user == null || !BCrypt.checkpw(loginReq.password, user.passwordHash)) {
            JsonUtil.error(res, 401, "Invalid credentials");
            return;
        }

        String token = JwtUtil.generateToken(user.id, user.companyId);
        user.passwordHash = null; // Don't leak the hash to the frontend

        JsonUtil.send(res, 200, Map.of("token", token, "user", user));
    }
}