package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.VoucherItems;
import in.onesoft.pos.jooq.tables.records.VoucherItemsRecord;
import in.onesoft.pos.model.VoucherItem;

public class VoucherItemRepository extends BaseRepository<VoucherItemsRecord, VoucherItem> {
    public VoucherItemRepository() {
        super(VoucherItems.VOUCHER_ITEMS, VoucherItems.VOUCHER_ITEMS.ID, VoucherItems.VOUCHER_ITEMS.COMPANY_ID,
                VoucherItem.class);
    }
}