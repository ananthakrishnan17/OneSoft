package in.onesoft.pos.model;

import in.onesoft.pos.model.enums.PaymentStatus;
import in.onesoft.pos.model.enums.PurchaseStatus;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

public class Purchase {
    public Long id;
    public Long companyId;
    public Long branchId;
    public String purchaseNo;
    public LocalDate purchaseDate;
    public Long supplierId;
    public Long poId;
    public String invoiceNo;
    public LocalDate invoiceDate;
    public PurchaseStatus status;
    public PaymentStatus paymentStatus;
    public BigDecimal subtotal;
    public BigDecimal taxAmount;
    public BigDecimal discountAmount;
    public BigDecimal roundOff;
    public BigDecimal netAmount;
    public BigDecimal paidAmount;
    public BigDecimal balanceAmount;
    public LocalDate dueDate;
    public String remarks;
    public OffsetDateTime createdAt;
}