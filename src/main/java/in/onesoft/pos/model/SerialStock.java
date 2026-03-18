package in.onesoft.pos.model;

import java.time.OffsetDateTime;

public class SerialStock {
    public Long id;
    public Long companyId;
    public Long branchId;
    public Long productId;
    public Long batchStockId;
    public String serialNo;
    public Boolean isAvailable;
    public OffsetDateTime createdAt;
}