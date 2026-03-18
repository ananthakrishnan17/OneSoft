package in.onesoft.pos.servlet;

import in.onesoft.pos.model.VoucherItem;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.VoucherItemRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/voucher-items/*")
public class VoucherItemServlet extends BaseServlet<VoucherItem> {
    private final VoucherItemRepository repo = new VoucherItemRepository();

    @Override
    protected BaseRepository<?, VoucherItem> getRepository() {
        return repo;
    }

    @Override
    protected Class<VoucherItem> getPojoClass() {
        return VoucherItem.class;
    }
}