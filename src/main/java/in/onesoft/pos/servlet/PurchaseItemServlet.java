package in.onesoft.pos.servlet;

import in.onesoft.pos.model.PurchaseItem;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.PurchaseItemRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/purchase-items/*")
public class PurchaseItemServlet extends BaseServlet<PurchaseItem> {
    private final PurchaseItemRepository repo = new PurchaseItemRepository();

    @Override
    protected BaseRepository<?, PurchaseItem> getRepository() {
        return repo;
    }

    @Override
    protected Class<PurchaseItem> getPojoClass() { return PurchaseItem.class; }
}