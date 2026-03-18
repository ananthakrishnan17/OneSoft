package in.onesoft.pos.servlet;

import in.onesoft.pos.model.Branch; // Map this to your jOOQ-generated POJO
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/branches/*")
public class BranchServlet extends BaseServlet<Branch> {
    private final BranchRepository repo = new BranchRepository();

    @Override
    protected BaseRepository<?, Branch> getRepository() {
        return repo;
    }

    @Override
    protected Class<Branch> getPojoClass() {
        return Branch.class;
    }
}