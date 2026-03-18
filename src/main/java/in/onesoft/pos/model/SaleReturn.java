package in.onesoft.pos.model;

import in.onesoft.pos.model.enums.BillStatus;
import in.onesoft.pos.model.enums.PaymentMode;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class SaleReturn {
    public Long id;
    public Long companyId;
    public Long branchId;
    public String returnNo;
    public OffsetDateTime returnDate;
    public Long originalSaleBillId;
    public Long customerId;
    public Long cashierId;
    public PaymentMode paymentMode;
    public BillStatus status;
    public BigDecimal subtotal;
    public BigDecimal discountAmount;
    public BigDecimal taxAmount;
    public BigDecimal roundOff;
    public BigDecimal netAmount;
    public BigDecimal refundAmount;
    public String reason;
    public OffsetDateTime createdAt;
}