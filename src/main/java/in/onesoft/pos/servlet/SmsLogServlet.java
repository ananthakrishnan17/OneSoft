package in.onesoft.pos.servlet;

import in.onesoft.pos.model.SmsLog;
import in.onesoft.pos.repository.BaseRepository;
import in.onesoft.pos.repository.SmsLogRepository;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/api/sms-logs/*")
public class SmsLogServlet extends BaseServlet<SmsLog> {
    private final SmsLogRepository repo = new SmsLogRepository();

    @Override
    protected BaseRepository<?, SmsLog> getRepository() {
        return repo;
    }

    @Override
    protected Class<SmsLog> getPojoClass() {
        return SmsLog.class;
    }
}