package in.onesoft.pos.servlet;

import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.util.JsonUtil;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseServlet<P> extends HttpServlet {

    protected abstract BaseRepository<?, P> getRepository();

    protected abstract Class<P> getPojoClass();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Long companyId = getCompanyId(req);
        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            JsonUtil.send(res, 200, getRepository().findAll(companyId));
        } else {
            Long id = parseLong(pathInfo.substring(1));
            P entity = getRepository().findById(companyId, id);
            if (entity == null) {
                JsonUtil.error(res, 404, "Not found");
            } else {
                JsonUtil.send(res, 200, entity);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            P pojo = JsonUtil.parse(req, getPojoClass());
            P created = getRepository().create(pojo);
            JsonUtil.send(res, 201, created);
        } catch (IllegalArgumentException e) {
            JsonUtil.error(res, 400, e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            String pathInfo = req.getPathInfo();
            if (pathInfo == null || pathInfo.equals("/")) {
                JsonUtil.error(res, 400, "ID required for update");
                return;
            }

            Long id = parseLong(pathInfo.substring(1));
            Long companyId = getCompanyId(req);
            P pojo = JsonUtil.parse(req, getPojoClass());

            P updated = getRepository().update(companyId, id, pojo);
            JsonUtil.send(res, 200, updated);
        } catch (IllegalArgumentException e) {
            JsonUtil.error(res, 400, e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String pathInfo = req.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            JsonUtil.error(res, 400, "ID required for deletion");
            return;
        }

        Long id = parseLong(pathInfo.substring(1));
        Long companyId = getCompanyId(req);

        if (getRepository().delete(companyId, id)) {
            JsonUtil.send(res, 204, null); // 204 No Content
        } else {
            JsonUtil.error(res, 404, "Not found");
        }
    }

    protected Long parseLong(String val) {
        if (val == null || val.trim().isEmpty())
            return null;
        return Long.parseLong(val.trim());
    }

    protected Long getCompanyId(HttpServletRequest req) {
        Long secureCompanyId = (Long) req.getAttribute("companyId");
        if (secureCompanyId != null) return secureCompanyId;
        return parseLong(req.getParameter("companyId"));
    }
}