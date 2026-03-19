package in.onesoft.pos.dao.auth;

import in.onesoft.pos.db.Database;
import in.onesoft.pos.jooq.tables.Users;
import in.onesoft.pos.jooq.tables.records.UsersRecord;

public class AuthDao {

    public UsersRecord findByUsername(String username) {
        return Database.ctx().selectFrom(Users.USERS)
                .where(Users.USERS.USERNAME.eq(username))
                .fetchOne();
    }
}