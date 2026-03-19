package in.onesoft.pos.dao.master;

import in.onesoft.pos.db.Database;
import in.onesoft.pos.jooq.tables.Users;
import in.onesoft.pos.model.User;

public class UserDao {

    public User findByUsername(String companyId, String username) {
        // Using jOOQ purely for data access, returning the Model
        return Database.ctx().selectFrom(Users.USERS)
                .where(Users.USERS.COMPANY_ID.eq(companyId))
                .and(Users.USERS.USERNAME.eq(username))
                // Removed .and(Users.USERS.IS_ACTIVE.eq(true)) because it doesn't exist in your
                // current jOOQ Users schema
                .fetchOneInto(User.class);
    }

}