package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.SmsLog;
import in.onesoft.pos.jooq.tables.records.SmsLogRecord;

public class SmsLogRepository extends BaseRepository<SmsLogRecord, in.onesoft.pos.model.SmsLog> {
    public SmsLogRepository() {
        super(SmsLog.SMS_LOG, SmsLog.SMS_LOG.ID, SmsLog.SMS_LOG.COMPANY_ID, in.onesoft.pos.model.SmsLog.class);
    }
}