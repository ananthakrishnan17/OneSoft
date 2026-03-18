package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.BackupLog;
import in.onesoft.pos.jooq.tables.records.BackupLogRecord;

public class BackupLogRepository extends BaseRepository<BackupLogRecord, in.onesoft.pos.model.BackupLog> {
    public BackupLogRepository() {
        super(BackupLog.BACKUP_LOG, BackupLog.BACKUP_LOG.ID, BackupLog.BACKUP_LOG.COMPANY_ID,
                in.onesoft.pos.model.BackupLog.class);
    }
}