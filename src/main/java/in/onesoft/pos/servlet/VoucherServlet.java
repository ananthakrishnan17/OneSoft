package in.onesoft.pos.servlet;

import in.onesoft.pos.model.Voucher;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.VoucherRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/vouchers/*")
public class VoucherServlet extends BaseServlet<Voucher> {
    private final VoucherRepository repo = new VoucherRepository();

    @Override
    protected BaseRepository<?, Voucher> getRepository() {
        return repo;
    }

    @Override
    protected Class<Voucher> getPojoClass() {
        return Voucher.class;
    }
}