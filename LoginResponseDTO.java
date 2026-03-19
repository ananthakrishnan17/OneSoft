package in.onesoft.pos.dto.auth;

public class LoginResponseDTO {
    public String token;
    public LoginUserDTO user;

    public LoginResponseDTO(String token, LoginUserDTO user) {
        this.token = token;
        this.user = user;
    }
}