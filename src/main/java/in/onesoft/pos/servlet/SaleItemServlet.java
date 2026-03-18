package in.onesoft.pos.servlet;

import in.onesoft.pos.model.SaleItem;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.SaleItemRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/sale-items/*")
public class SaleItemServlet extends BaseServlet<SaleItem> {
    private final SaleItemRepository repo = new SaleItemRepository();

    @Override
    protected BaseRepository<?, SaleItem> getRepository() {
        return repo;
    }

    @Override
    protected Class<SaleItem> getPojoClass() {
        return SaleItem.class;
    }
}