package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.StockLedger;
import in.onesoft.pos.jooq.tables.records.StockLedgerRecord;

public class StockLedgerRepository extends BaseRepository<StockLedgerRecord, in.onesoft.pos.model.StockLedger> {
    public StockLedgerRepository() {
        super(StockLedger.STOCK_LEDGER, StockLedger.STOCK_LEDGER.ID, StockLedger.STOCK_LEDGER.COMPANY_ID,
                in.onesoft.pos.model.StockLedger.class);
    }
}