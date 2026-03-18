package in.onesoft.pos.model;

import java.time.OffsetDateTime;

public class AccountGroup {
    public Long id;
    public Long companyId;
    public Long parentGroupId;
    public String groupName;
    public OffsetDateTime createdAt;
}