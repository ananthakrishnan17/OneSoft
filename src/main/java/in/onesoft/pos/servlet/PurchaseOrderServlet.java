package in.onesoft.pos.servlet;

import in.onesoft.pos.model.PurchaseOrder;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.PurchaseOrderRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/purchase-orders/*")
public class PurchaseOrderServlet extends BaseServlet<PurchaseOrder> {
    private final PurchaseOrderRepository repo = new PurchaseOrderRepository();

    @Override
    protected BaseRepository<?, PurchaseOrder> getRepository() {
        return repo;
    }

    @Override
    protected Class<PurchaseOrder> getPojoClass() {
        return PurchaseOrder.class;
    }
}