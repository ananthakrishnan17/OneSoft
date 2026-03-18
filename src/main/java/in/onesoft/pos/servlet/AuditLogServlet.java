package in.onesoft.pos.servlet;

import in.onesoft.pos.model.AuditLog;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.AuditLogRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/audit-logs/*")
public class AuditLogServlet extends BaseServlet<AuditLog> {
    private final AuditLogRepository repo = new AuditLogRepository();

    @Override
    protected BaseRepository<?, AuditLog> getRepository() {
        return repo;
    }

    @Override
    protected Class<AuditLog> getPojoClass() {
        return AuditLog.class;
    }
}