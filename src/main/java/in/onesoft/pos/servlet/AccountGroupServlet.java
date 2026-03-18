package in.onesoft.pos.servlet;

import in.onesoft.pos.model.AccountGroup;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.AccountGroupRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/account-groups/*")
public class AccountGroupServlet extends BaseServlet<AccountGroup> {
    private final AccountGroupRepository repo = new AccountGroupRepository();

    @Override
    protected BaseRepository<?, AccountGroup> getRepository() {
        return repo;
    }

    @Override
    protected Class<AccountGroup> getPojoClass() {
        return AccountGroup.class;
    }
}