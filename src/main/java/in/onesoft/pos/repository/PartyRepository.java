package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.Parties;
import in.onesoft.pos.jooq.tables.records.PartiesRecord;
import in.onesoft.pos.model.Party;

public class PartyRepository extends BaseRepository<PartiesRecord, Party> {
    public PartyRepository() {
        super(Parties.PARTIES, Parties.PARTIES.ID, Parties.PARTIES.COMPANY_ID, Party.class);
    }
}