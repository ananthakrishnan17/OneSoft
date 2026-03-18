package in.onesoft.pos.servlet;

import in.onesoft.pos.model.Company;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.CompanyRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/companies/*")
public class CompanyServlet extends BaseServlet<Company> {

    private final CompanyRepository repo = new CompanyRepository();

    @Override protected BaseRepository<?, Company> getRepository() { return repo; }
    @Override protected Class<Company> getPojoClass() { return Company.class; }
    }
}