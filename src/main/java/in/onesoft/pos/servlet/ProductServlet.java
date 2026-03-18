package in.onesoft.pos.servlet;

import in.onesoft.pos.model.Product;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.ProductRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/products/*")
public class ProductServlet extends BaseServlet<Product> {
    private final ProductRepository repo = new ProductRepository();

    @Override
    protected BaseRepository<?, Product> getRepository() {
        return repo;
    }

    @Override
    protected Class<Product> getPojoClass() { return Product.class; }
}