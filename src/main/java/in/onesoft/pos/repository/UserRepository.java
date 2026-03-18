package in.onesoft.pos.repository;

import in.onesoft.pos.db.Database;
import in.onesoft.pos.jooq.tables.Users;
import in.onesoft.pos.jooq.tables.records.UsersRecord;
import in.onesoft.pos.model.User;
import org.mindrot.jbcrypt.BCrypt;

public class UserRepository extends BaseRepository<UsersRecord, User> {

    public UserRepository() {
        super(Users.USERS, Users.USERS.ID, Users.USERS.COMPANY_ID, User.class);
    }

    public User findByUsername(Long companyId, String username) {
        return Database.ctx().selectFrom(table)
                .where(Users.USERS.COMPANY_ID.eq(companyId))
                .and(Users.USERS.USERNAME.eq(username))
                .and(Users.USERS.IS_ACTIVE.eq(true))
                .fetchOneInto(User.class);
    }

    @Override
    public User create(User user) {
        // Password BCrypt hash
        user.passwordHash = BCrypt.hashpw(user.passwordHash, BCrypt.gensalt(12));
        user = super.create(user);
        user.passwordHash = null; // Response-ல hash return பண்ண வேண்டாம்
        return user;
    }
}