package in.onesoft.pos.servlet;

import in.onesoft.pos.model.SerialStock;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.SerialStockRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/serial-stocks/*")
public class SerialStockServlet extends BaseServlet<SerialStock> {
    private final SerialStockRepository repo = new SerialStockRepository();

    @Override
    protected BaseRepository<?, SerialStock> getRepository() {
        return repo;
    }

    @Override
    protected Class<SerialStock> getPojoClass() {
        return SerialStock.class;
    }
}