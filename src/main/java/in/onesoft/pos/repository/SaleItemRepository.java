package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.SaleItems;
import in.onesoft.pos.jooq.tables.records.SaleItemsRecord;
import in.onesoft.pos.model.SaleItem;

public class SaleItemRepository extends BaseRepository<SaleItemsRecord, SaleItem> {
    public SaleItemRepository() {
        super(SaleItems.SALE_ITEMS, SaleItems.SALE_ITEMS.ID, SaleItems.SALE_ITEMS.COMPANY_ID, SaleItem.class);
    }
}