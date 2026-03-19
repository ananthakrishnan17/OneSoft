package in.onesoft.pos.controller.auth;

import in.onesoft.pos.dto.auth.LoginRequestDTO;
import in.onesoft.pos.dto.auth.LoginResponseDTO;
import in.onesoft.pos.service.auth.AuthService;
import in.onesoft.pos.util.JsonUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/api/auth/login")
public class AuthController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(AuthController.class.getName());
    private final AuthService authService = new AuthService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            LoginRequestDTO loginReq = JsonUtil.parse(req, LoginRequestDTO.class);

            if (loginReq == null ||
                    loginReq.username == null || loginReq.username.trim().isEmpty() ||
                    loginReq.password == null || loginReq.password.trim().isEmpty()) {
                JsonUtil.error(res, 400, "Username and password are required and cannot be blank.");
                return;
            }

            LoginResponseDTO responseDTO = authService.authenticate(loginReq);

            if (responseDTO == null) {
                JsonUtil.error(res, 401, "Invalid username or password");
            } else {
                JsonUtil.send(res, 200, responseDTO);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Authentication internal server error", e);
            JsonUtil.error(res, 500, "An internal server error occurred during authentication.");
        }
    }
}