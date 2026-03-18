package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.AuditLog;
import in.onesoft.pos.jooq.tables.records.AuditLogRecord;

public class AuditLogRepository extends BaseRepository<AuditLogRecord, in.onesoft.pos.model.AuditLog> {
    public AuditLogRepository() {
        super(AuditLog.AUDIT_LOG, AuditLog.AUDIT_LOG.ID, AuditLog.AUDIT_LOG.COMPANY_ID, in.onesoft.pos.model.AuditLog.class);
    }
}