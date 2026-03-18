package in.onesoft.pos.servlet;

import in.onesoft.pos.model.User;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.UserRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/users/*")
public class UserServlet extends BaseServlet<User> {

    private final UserRepository repo = new UserRepository();

    @Override
    protected BaseRepository<?, User> getRepository() {
        return repo;
    }

    @Override
    protected Class<User> getPojoClass() {
        return User.class;
    }
}