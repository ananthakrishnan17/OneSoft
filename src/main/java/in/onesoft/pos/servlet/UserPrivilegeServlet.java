package in.onesoft.pos.servlet;

import in.onesoft.pos.model.UserPrivilege;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.UserPrivilegeRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/user-privileges/*")
public class UserPrivilegeServlet extends BaseServlet<UserPrivilege> {
    private final UserPrivilegeRepository repo = new UserPrivilegeRepository();

    @Override
    protected BaseRepository<?, UserPrivilege> getRepository() {
        return repo;
    }

    @Override
    protected Class<UserPrivilege> getPojoClass() {
        return UserPrivilege.class;
    }
}