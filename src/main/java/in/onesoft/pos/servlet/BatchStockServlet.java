package in.onesoft.pos.servlet;

import in.onesoft.pos.model.BatchStock;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.BatchStockRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/batch-stocks/*")
public class BatchStockServlet extends BaseServlet<BatchStock> {
    private final BatchStockRepository repo = new BatchStockRepository();

    @Override
    protected BaseRepository<?, BatchStock> getRepository() {
        return repo;
    }

    @Override
    protected Class<BatchStock> getPojoClass() {
        return BatchStock.class;
    }
}