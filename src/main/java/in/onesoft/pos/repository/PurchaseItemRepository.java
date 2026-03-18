package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.PurchaseItems;
import in.onesoft.pos.jooq.tables.records.PurchaseItemsRecord;
import in.onesoft.pos.model.PurchaseItem;

public class PurchaseItemRepository extends BaseRepository<PurchaseItemsRecord, PurchaseItem> {
    public PurchaseItemRepository() {
        super(PurchaseItems.PURCHASE_ITEMS, PurchaseItems.PURCHASE_ITEMS.ID, PurchaseItems.PURCHASE_ITEMS.COMPANY_ID,
                PurchaseItem.class);
    }
}