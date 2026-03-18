package in.onesoft.pos.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

public class PurchaseItem {
    public Long id;
    public Long companyId;
    public Long purchaseId;
    public Long productId;
    public Long batchStockId;
    public BigDecimal qty;
    public BigDecimal freeQty;
    public BigDecimal unitCost;
    public BigDecimal discountAmount;
    public BigDecimal taxableAmount;
    public BigDecimal gstPercent;
    public BigDecimal gstAmount;
    public BigDecimal cessAmount;
    public BigDecimal splCessAmount;
    public BigDecimal lineTotal;
    public LocalDate expiryDate;
    public OffsetDateTime createdAt;
}