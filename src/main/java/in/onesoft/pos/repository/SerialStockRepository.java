package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.SerialStock;
import in.onesoft.pos.jooq.tables.records.SerialStockRecord;

public class SerialStockRepository extends BaseRepository<SerialStockRecord, in.onesoft.pos.model.SerialStock> {
    public SerialStockRepository() {
        super(SerialStock.SERIAL_STOCK, SerialStock.SERIAL_STOCK.ID, SerialStock.SERIAL_STOCK.COMPANY_ID, in.onesoft.pos.model.SerialStock.class);
    }
}