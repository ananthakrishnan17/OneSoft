package in.onesoft.pos.model;

import java.time.OffsetDateTime;

public class AuditLog {
    public Long id;
    public Long companyId;
    public Long userId;
    public String action;
    public String tableName;
    public Long recordId;
    public String reason;
    public Object oldData;
    public Object newData;
    public OffsetDateTime createdAt;
}