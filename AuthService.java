package in.onesoft.pos.service.auth;

import in.onesoft.pos.dao.auth.AuthDao;
import in.onesoft.pos.dto.auth.LoginRequestDTO;
import in.onesoft.pos.dto.auth.LoginResponseDTO;
import in.onesoft.pos.dto.auth.LoginUserDTO;
import in.onesoft.pos.jooq.tables.records.UsersRecord;
import in.onesoft.pos.security.JwtUtil;
import org.mindrot.jbcrypt.BCrypt;

public class AuthService {

    private final AuthDao authDao = new AuthDao();

    public LoginResponseDTO authenticate(LoginRequestDTO req) {
        UsersRecord userRecord = authDao.findByUsername(req.username);

        if (userRecord == null || !BCrypt.checkpw(req.password, userRecord.getPasswordHash())) {
            return null;
        }

        String token = JwtUtil.generateToken(userRecord.getId(), userRecord.getCompanyId());

        LoginUserDTO userDTO = new LoginUserDTO(
                userRecord.getId(),
                userRecord.getUsername(),
                userRecord.getCompanyId());

        return new LoginResponseDTO(token, userDTO);
    }
}