package in.onesoft.pos.servlet;

import in.onesoft.pos.model.SaleBill;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.SaleBillRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/sale-bills/*")
public class SaleBillServlet extends BaseServlet<SaleBill> {
    private final SaleBillRepository repo = new SaleBillRepository();

    @Override
    protected BaseRepository<?, SaleBill> getRepository() {
        return repo;
    }

    @Override
    protected Class<SaleBill> getPojoClass() {
        return SaleBill.class;
    }
}