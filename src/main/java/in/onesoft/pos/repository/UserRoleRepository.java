package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.UserRoles;
import in.onesoft.pos.jooq.tables.records.UserRolesRecord;
import in.onesoft.pos.model.UserRole;

public class UserRoleRepository extends BaseRepository<UserRolesRecord, UserRole> {
    public UserRoleRepository() {
        super(UserRoles.USER_ROLES, UserRoles.USER_ROLES.ID, UserRoles.USER_ROLES.COMPANY_ID, UserRole.class);
    }
}