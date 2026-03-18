package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.Barcodes;
import in.onesoft.pos.jooq.tables.records.BarcodesRecord;
import in.onesoft.pos.model.Barcode;

public class BarcodeRepository extends BaseRepository<BarcodesRecord, Barcode> {
    public BarcodeRepository() {
        super(Barcodes.BARCODES, Barcodes.BARCODES.ID, Barcodes.BARCODES.COMPANY_ID, Barcode.class);
    }
}