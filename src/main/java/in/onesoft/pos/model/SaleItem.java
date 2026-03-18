package in.onesoft.pos.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class SaleItem {
    public Long id;
    public Long companyId;
    public Long saleBillId;
    public Long productId;
    public Long batchStockId;
    public Long serialStockId;
    public BigDecimal qty;
    public BigDecimal freeQty;
    public BigDecimal unitPrice;
    public BigDecimal discountAmount;
    public BigDecimal taxableAmount;
    public BigDecimal gstPercent;
    public BigDecimal gstAmount;
    public BigDecimal cessAmount;
    public BigDecimal splCessAmount;
    public BigDecimal lineTotal;
    public OffsetDateTime createdAt;
}