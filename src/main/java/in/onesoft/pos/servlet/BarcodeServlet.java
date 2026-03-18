package in.onesoft.pos.servlet;

import in.onesoft.pos.model.Barcode;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.BarcodeRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/barcodes/*")
public class BarcodeServlet extends BaseServlet<Barcode> {
    private final BarcodeRepository repo = new BarcodeRepository();

    @Override
    protected BaseRepository<?, Barcode> getRepository() {
        return repo;
    }

    @Override
    protected Class<Barcode> getPojoClass() {
        return Barcode.class;
    }
}