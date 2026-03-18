package in.onesoft.pos.servlet;

import in.onesoft.pos.model.StockLedger;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.StockLedgerRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/stock-ledgers/*")
public class StockLedgerServlet extends BaseServlet<StockLedger> {
    private final StockLedgerRepository repo = new StockLedgerRepository();

    @Override
    protected BaseRepository<?, StockLedger> getRepository() {
        return repo;
    }

    @Override
    protected Class<StockLedger> getPojoClass() {
        return StockLedger.class;
    }
}