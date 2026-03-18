package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.Vouchers;
import in.onesoft.pos.jooq.tables.records.VouchersRecord;
import in.onesoft.pos.model.Voucher;

public class VoucherRepository extends BaseRepository<VouchersRecord, Voucher> {
    public VoucherRepository() {
        super(Vouchers.VOUCHERS, Vouchers.VOUCHERS.ID, Vouchers.VOUCHERS.COMPANY_ID, Voucher.class);
    }
}