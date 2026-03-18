package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.SaleReturns;
import in.onesoft.pos.jooq.tables.records.SaleReturnsRecord;
import in.onesoft.pos.model.SaleReturn;

public class SaleReturnRepository extends BaseRepository<SaleReturnsRecord, SaleReturn> {
    public SaleReturnRepository() {
        super(SaleReturns.SALE_RETURNS, SaleReturns.SALE_RETURNS.ID, SaleReturns.SALE_RETURNS.COMPANY_ID,
                SaleReturn.class);
    }
}