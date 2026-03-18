package in.onesoft.pos.servlet;

import in.onesoft.pos.model.Purchase;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.PurchaseRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/purchases/*")
public class PurchaseServlet extends BaseServlet<Purchase> {
    private final PurchaseRepository repo = new PurchaseRepository();

    @Override
    protected BaseRepository<?, Purchase> getRepository() {
        return repo;
    }

    @Override
    protected Class<Purchase> getPojoClass() {
        return Purchase.class;
    }
}