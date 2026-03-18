package in.onesoft.pos.servlet;

import in.onesoft.pos.model.LedgerAccount;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.LedgerAccountRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/ledger-accounts/*")
public class LedgerAccountServlet extends BaseServlet<LedgerAccount> {
    private final LedgerAccountRepository repo = new LedgerAccountRepository();

    @Override
    protected BaseRepository<?, LedgerAccount> getRepository() {
        return repo;
    }

    @Override
    protected Class<LedgerAccount> getPojoClass() {
        return LedgerAccount.class;
    }
}