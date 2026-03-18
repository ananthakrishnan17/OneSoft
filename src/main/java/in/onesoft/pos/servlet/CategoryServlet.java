package in.onesoft.pos.servlet;

import in.onesoft.pos.model.Category;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.CategoryRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/categories/*")
public class CategoryServlet extends BaseServlet<Category> {
    private final CategoryRepository repo = new CategoryRepository();

    @Override
    protected BaseRepository<?, Category> getRepository() {
        return repo;
    }

    @Override
    protected Class<Category> getPojoClass() {
        return Category.class;
    }
}