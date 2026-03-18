package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.AccountGroups;
import in.onesoft.pos.jooq.tables.records.AccountGroupsRecord;
import in.onesoft.pos.model.AccountGroup;

public class AccountGroupRepository extends BaseRepository<AccountGroupsRecord, AccountGroup> {
    public AccountGroupRepository() {
        super(AccountGroups.ACCOUNT_GROUPS, AccountGroups.ACCOUNT_GROUPS.ID, AccountGroups.ACCOUNT_GROUPS.COMPANY_ID,
                AccountGroup.class);
    }
}