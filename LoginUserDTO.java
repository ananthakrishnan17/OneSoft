package in.onesoft.pos.dto.auth;

public class LoginUserDTO {
    public String id;
    public String username;
    public String companyId;

    public LoginUserDTO(String id, String username, String companyId) {
        this.id = id;
        this.username = username;
        this.companyId = companyId;
    }
}