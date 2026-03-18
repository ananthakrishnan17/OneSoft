package in.onesoft.pos.model;

import in.onesoft.pos.model.enums.VoucherType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

public class Voucher {
    public Long id;
    public Long companyId;
    public Long branchId;
    public String voucherNo;
    public LocalDate voucherDate;
    public VoucherType voucherType;
    public String narration;
    public String referenceNo;
    public BigDecimal totalAmount;
    public Long createdBy;
    public OffsetDateTime createdAt;
}