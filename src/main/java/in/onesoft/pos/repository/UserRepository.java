package in.onesoft.pos.repository;

import in.onesoft.pos.id.IdGenerator;
import in.onesoft.pos.model.User;
import in.onesoft.pos.routing.ScopeRouter;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

/**
 * User CRUD — CompanyRepository-ஓட same pattern.
 * jOOQ table class generate பண்ணலன்னா DSL.table() use பண்ணலாம்.
 */
public class UserRepository {

    private static final org.jooq.Table<?> T = table("users");

    public List<User> findByCompany(String companyId) {
        String scopeId = IdGenerator.extractScopeId(companyId);
        DSLContext ctx = ScopeRouter.routeByScopeId(scopeId);

        return ctx.select()
                .from(T)
                .where(field("company_id").eq(companyId))
                .and(field("is_active").eq(true))
                .fetchInto(User.class);
    }

    public User findById(String id) {
        String scopeId = IdGenerator.extractScopeId(id);
        DSLContext ctx = ScopeRouter.routeByScopeId(scopeId);

        return ctx.select()
                .from(T)
                .where(field("id").eq(id))
                .fetchOneInto(User.class);
    }

    public User findByUsername(String scopeId, String username) {
        DSLContext ctx = ScopeRouter.routeByScopeId(scopeId);

        return ctx.select()
                .from(T)
                .where(field("username").eq(username))
                .and(field("is_active").eq(true))
                .fetchOneInto(User.class);
    }

    public User create(User user) {
        // company-ஓட scopeId use பண்ணு
        String scopeId = IdGenerator.extractScopeId(user.companyId);
        String newId = IdGenerator.generate(scopeId);

        // Password BCrypt hash
        String hash = BCrypt.hashpw(user.passwordHash, BCrypt.gensalt(12));

        DSLContext ctx = ScopeRouter.routeByScopeId(scopeId);

        ctx.insertInto(T)
                .set(field("id"), newId)
                .set(field("scope_id"), scopeId)
                .set(field("company_id"), user.companyId)
                .set(field("role_id"), user.roleId)
                .set(field("username"), user.username)
                .set(field("password_hash"), hash)
                .set(field("full_name"), user.fullName)
                .set(field("phone"), user.phone)
                .set(field("email"), user.email)
                .set(field("is_active"), true)
                .execute();

        user.id = newId;
        user.scopeId = scopeId;
        user.passwordHash = null; // Response-ல hash return பண்ண வேண்டாம்
        return user;
    }

    public boolean updateActive(String id, boolean active) {
        String scopeId = IdGenerator.extractScopeId(id);
        DSLContext ctx = ScopeRouter.routeByScopeId(scopeId);

        int updated = ctx.update(T)
                .set(field("is_active"), active)
                .where(field("id").eq(id))
                .execute();

        return updated > 0;
    }
}