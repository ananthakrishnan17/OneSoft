package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.BatchStock;
import in.onesoft.pos.jooq.tables.records.BatchStockRecord;

public class BatchStockRepository extends BaseRepository<BatchStockRecord, in.onesoft.pos.model.BatchStock> {
    public BatchStockRepository() {
        super(BatchStock.BATCH_STOCK, BatchStock.BATCH_STOCK.ID, BatchStock.BATCH_STOCK.COMPANY_ID,
                in.onesoft.pos.model.BatchStock.class);
    }
}