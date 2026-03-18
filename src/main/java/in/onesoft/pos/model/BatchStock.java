package in.onesoft.pos.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

public class BatchStock {
    public Long id;
    public Long companyId;
    public Long branchId;
    public Long productId;
    public String batchNo;
    public LocalDate mfgDate;
    public LocalDate expiryDate;
    public BigDecimal purchaseRate;
    public BigDecimal saleRate;
    public BigDecimal mrp;
    public BigDecimal qtyOnHand;
    public OffsetDateTime createdAt;
}