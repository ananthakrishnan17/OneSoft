package in.onesoft.pos.model;

import java.time.OffsetDateTime;

public class BackupLog {
    public Long id;
    public Long companyId;
    public String backupType;
    public String filePath;
    public Long fileSizeBytes;
    public String status;
    public String notes;
    public OffsetDateTime createdAt;
}