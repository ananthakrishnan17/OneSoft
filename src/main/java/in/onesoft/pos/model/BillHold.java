package in.onesoft.pos.model;

import in.onesoft.pos.model.enums.BillStatus;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class BillHold {
    public Long id;
    public Long companyId;
    public Long branchId;
    public String holdNo;
    public Long customerId;
    public Long cashierId;
    public OffsetDateTime holdDate;
    public BigDecimal subtotal;
    public BigDecimal discountAmount;
    public BigDecimal taxAmount;
    public BigDecimal roundOff;
    public BigDecimal netAmount;
    public String remarks;
    public BillStatus status;
    public OffsetDateTime createdAt;
}