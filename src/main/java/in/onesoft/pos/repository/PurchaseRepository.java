package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.Purchases;
import in.onesoft.pos.jooq.tables.records.PurchasesRecord;
import in.onesoft.pos.model.Purchase;

public class PurchaseRepository extends BaseRepository<PurchasesRecord, Purchase> {
    public PurchaseRepository() {
        super(Purchases.PURCHASES, Purchases.PURCHASES.ID, Purchases.PURCHASES.COMPANY_ID, Purchase.class);
    }
}