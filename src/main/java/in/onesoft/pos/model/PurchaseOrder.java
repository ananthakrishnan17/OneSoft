package in.onesoft.pos.model;

import in.onesoft.pos.model.enums.PurchaseStatus;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

public class PurchaseOrder {
    public Long id;
    public Long companyId;
    public Long branchId;
    public String poNo;
    public LocalDate poDate;
    public Long supplierId;
    public PurchaseStatus status;
    public LocalDate expectedDate;
    public BigDecimal totalQty;
    public BigDecimal subtotal;
    public BigDecimal taxAmount;
    public BigDecimal discountAmount;
    public BigDecimal roundOff;
    public BigDecimal netAmount;
    public String remarks;
    public OffsetDateTime createdAt;
}