package in.onesoft.pos.model;

import in.onesoft.pos.model.enums.StockTxnType;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class StockLedger {
    public Long id;
    public Long companyId;
    public Long branchId;
    public Long productId;
    public Long batchStockId;
    public Long serialStockId;
    public StockTxnType txnType;
    public OffsetDateTime txnDate;
    public String refTable;
    public Long refId;
    public BigDecimal qty;
    public BigDecimal rate;
    public BigDecimal amount;
    public String remarks;
    public OffsetDateTime createdAt;
}