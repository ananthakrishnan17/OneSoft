package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.BillHolds;
import in.onesoft.pos.jooq.tables.records.BillHoldsRecord;
import in.onesoft.pos.model.BillHold;

public class BillHoldRepository extends BaseRepository<BillHoldsRecord, BillHold> {
    public BillHoldRepository() {
        super(BillHolds.BILL_HOLDS, BillHolds.BILL_HOLDS.ID, BillHolds.BILL_HOLDS.COMPANY_ID, BillHold.class);
    }
}