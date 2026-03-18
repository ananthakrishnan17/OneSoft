package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.ProductPrices;
import in.onesoft.pos.jooq.tables.records.ProductPricesRecord;
import in.onesoft.pos.model.ProductPrice;

public class ProductPriceRepository extends BaseRepository<ProductPricesRecord, ProductPrice> {
    public ProductPriceRepository() {
        super(ProductPrices.PRODUCT_PRICES, ProductPrices.PRODUCT_PRICES.ID, ProductPrices.PRODUCT_PRICES.COMPANY_ID,
                ProductPrice.class);
    }
}