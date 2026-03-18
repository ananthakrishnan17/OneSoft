package in.onesoft.pos.model;

import java.time.OffsetDateTime;

public class Category {
    public Long id;
    public Long companyId;
    public Long parentId;
    public String categoryName;
    public String description;
    public Boolean isActive;
    public OffsetDateTime createdAt;
}