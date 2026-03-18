package in.onesoft.pos.model;

import in.onesoft.pos.model.enums.BalanceType;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class LedgerAccount {
    public Long id;
    public Long companyId;
    public Long groupId;
    public Long partyId;
    public String accountCode;
    public String accountName;
    public BigDecimal openingBalance;
    public BalanceType balanceType;
    public Boolean isActive;
    public OffsetDateTime createdAt;
}