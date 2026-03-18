package in.onesoft.pos.model;

import in.onesoft.pos.model.enums.ProductPriceType;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class ProductPrice {
    public Long id;
    public Long companyId;
    public Long productId;
    public ProductPriceType priceType;
    public BigDecimal price;
    public OffsetDateTime effectiveFrom;
    public OffsetDateTime createdAt;
}