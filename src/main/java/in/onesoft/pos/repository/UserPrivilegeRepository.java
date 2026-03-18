package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.UserPrivileges;
import in.onesoft.pos.jooq.tables.records.UserPrivilegesRecord;
import in.onesoft.pos.model.UserPrivilege;

public class UserPrivilegeRepository extends BaseRepository<UserPrivilegesRecord, UserPrivilege> {
    public UserPrivilegeRepository() {
        super(UserPrivileges.USER_PRIVILEGES, UserPrivileges.USER_PRIVILEGES.ID,
                UserPrivileges.USER_PRIVILEGES.COMPANY_ID, UserPrivilege.class);
    }
}