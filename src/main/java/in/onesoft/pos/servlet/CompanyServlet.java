package in.onesoft.pos.servlet;

import in.onesoft.pos.model.Company;
import in.onesoft.pos.repository.CompanyRepository;
import in.onesoft.pos.util.JsonUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/api/companies/*")
public class CompanyServlet extends HttpServlet {

    private final CompanyRepository repo = new CompanyRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            String scopeId = req.getParameter("scopeId");
            if (scopeId == null)
                scopeId = "0000001";
            JsonUtil.send(res, 200, repo.findAll(scopeId));
        } else {
            String id = pathInfo.substring(1);
            Company company = repo.findById(id);
            if (company == null) {
                JsonUtil.send(res, 404, "Company not found");
            } else {
                JsonUtil.send(res, 200, company);
            }
        }
    }

    // POST /api/companies — புது company
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        Company company = JsonUtil.parse(req, Company.class);
        Company created = repo.create(company);
        JsonUtil.send(res, 201, created);
    }
}