package in.onesoft.pos.servlet;

import in.onesoft.pos.model.BackupLog;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.BackupLogRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/backup-logs/*")
public class BackupLogServlet extends BaseServlet<BackupLog> {
    private final BackupLogRepository repo = new BackupLogRepository();

    @Override
    protected BaseRepository<?, BackupLog> getRepository() {
        return repo;
    }

    @Override
    protected Class<BackupLog> getPojoClass() {
        return BackupLog.class;
    }
}