package in.onesoft.pos.model;

import java.time.OffsetDateTime;

public class Barcode {
    public Long id;
    public Long companyId;
    public Long productId;
    public String barcode;
    public Boolean isPrimary;
    public OffsetDateTime createdAt;
}