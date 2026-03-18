package in.onesoft.pos.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Product {
    public Long id;
    public Long companyId;
    public Long categoryId;
    public String itemCode;
    public String itemName;
    public String unit;
    public String hsnCode;
    public BigDecimal gstPercent;
    public BigDecimal cessPercent;
    public BigDecimal splCessPercent;
    public Boolean hasSerial;
    public Boolean hasBatch;
    public Boolean hasExpiry;
    public BigDecimal reorderLevel;
    public String location;
    public Boolean isActive;
    public OffsetDateTime createdAt;
}