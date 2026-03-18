package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.SaleBills;
import in.onesoft.pos.jooq.tables.records.SaleBillsRecord;
import in.onesoft.pos.model.SaleBill;

public class SaleBillRepository extends BaseRepository<SaleBillsRecord, SaleBill> {
    public SaleBillRepository() {
        super(SaleBills.SALE_BILLS, SaleBills.SALE_BILLS.ID, SaleBills.SALE_BILLS.COMPANY_ID, SaleBill.class);
    }
}