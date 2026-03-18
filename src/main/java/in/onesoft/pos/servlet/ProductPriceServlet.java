package in.onesoft.pos.servlet;

import in.onesoft.pos.model.ProductPrice;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.ProductPriceRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/product-prices/*")
public class ProductPriceServlet extends BaseServlet<ProductPrice> {
    private final ProductPriceRepository repo = new ProductPriceRepository();

    @Override
    protected BaseRepository<?, ProductPrice> getRepository() {
        return repo;
    }

    @Override
    protected Class<ProductPrice> getPojoClass() {
        return ProductPrice.class;
    }
}