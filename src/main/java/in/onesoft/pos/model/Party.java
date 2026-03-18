package in.onesoft.pos.model;

import in.onesoft.pos.model.enums.BalanceType;
import in.onesoft.pos.model.enums.PartyType;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Party {
    public Long id;
    public Long companyId;
    public PartyType partyType;
    public String name;
    public String phone;
    public String gstin;
    public String address;
    public Integer creditDays;
    public BigDecimal creditLimit;
    public Long loyaltyPoints;
    public BigDecimal openingBalance;
    public BalanceType balanceType;
    public Boolean isActive;
    public OffsetDateTime createdAt;
}