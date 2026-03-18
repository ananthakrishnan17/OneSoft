package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.PurchaseOrders;
import in.onesoft.pos.jooq.tables.records.PurchaseOrdersRecord;
import in.onesoft.pos.model.PurchaseOrder;

public class PurchaseOrderRepository extends BaseRepository<PurchaseOrdersRecord, PurchaseOrder> {
    public PurchaseOrderRepository() {
        super(PurchaseOrders.PURCHASE_ORDERS, PurchaseOrders.PURCHASE_ORDERS.ID,
                PurchaseOrders.PURCHASE_ORDERS.COMPANY_ID, PurchaseOrder.class);
    }
}