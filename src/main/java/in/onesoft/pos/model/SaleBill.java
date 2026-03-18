package in.onesoft.pos.model;

import in.onesoft.pos.model.enums.BillStatus;
import in.onesoft.pos.model.enums.BillType;
import in.onesoft.pos.model.enums.PaymentMode;
import in.onesoft.pos.model.enums.SaleType;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class SaleBill {
    public Long id;
    public Long companyId;
    public Long branchId;
    public String billNo;
    public OffsetDateTime billDate;
    public BillType billType;
    public SaleType saleType;
    public Long customerId;
    public Long cashierId;
    public BillStatus status;
    public PaymentMode paymentMode;
    public BigDecimal subtotal;
    public BigDecimal discountAmount;
    public BigDecimal taxAmount;
    public BigDecimal roundOff;
    public BigDecimal netAmount;
    public BigDecimal receivedAmount;
    public BigDecimal balanceAmount;
    public Long loyaltyPointsEarned;
    public String notes;
    public OffsetDateTime createdAt;
}