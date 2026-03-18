package in.onesoft.pos.model;

import java.time.OffsetDateTime;

public class UserPrivilege {
    public Long id;
    public Long companyId;
    public Long roleId;
    public String module;
    public Boolean canView;
    public Boolean canCreate;
    public Boolean canEdit;
    public Boolean canDelete;
    public Boolean canPrint;
    public OffsetDateTime createdAt;
}