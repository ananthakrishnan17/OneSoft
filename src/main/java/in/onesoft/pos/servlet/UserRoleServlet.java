package in.onesoft.pos.servlet;

import in.onesoft.pos.model.UserRole;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.UserRoleRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/user-roles/*")
public class UserRoleServlet extends BaseServlet<UserRole> {
    private final UserRoleRepository repo = new UserRoleRepository();

    @Override
    protected BaseRepository<?, UserRole> getRepository() {
        return repo;
    }

    @Override
    protected Class<UserRole> getPojoClass() {
        return UserRole.class;
    }
}