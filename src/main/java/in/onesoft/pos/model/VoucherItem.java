package in.onesoft.pos.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class VoucherItem {
    public Long id;
    public Long companyId;
    public Long voucherId;
    public Long ledgerAccountId;
    public BigDecimal drAmount;
    public BigDecimal crAmount;
    public String remarks;
    public OffsetDateTime createdAt;
}