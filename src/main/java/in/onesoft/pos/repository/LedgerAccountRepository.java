package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.LedgerAccounts;
import in.onesoft.pos.jooq.tables.records.LedgerAccountsRecord;
import in.onesoft.pos.model.LedgerAccount;

public class LedgerAccountRepository extends BaseRepository<LedgerAccountsRecord, LedgerAccount> {
    public LedgerAccountRepository() {
        super(LedgerAccounts.LEDGER_ACCOUNTS, LedgerAccounts.LEDGER_ACCOUNTS.ID,
                LedgerAccounts.LEDGER_ACCOUNTS.COMPANY_ID, LedgerAccount.class);
    }
}