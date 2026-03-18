package in.onesoft.pos.servlet;

import in.onesoft.pos.model.SaleReturn;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.SaleReturnRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/sale-returns/*")
public class SaleReturnServlet extends BaseServlet<SaleReturn> {
    private final SaleReturnRepository repo = new SaleReturnRepository();

    @Override
    protected BaseRepository<?, SaleReturn> getRepository() {
        return repo;
    }

    @Override
    protected Class<SaleReturn> getPojoClass() {
        return SaleReturn.class;
    }
}