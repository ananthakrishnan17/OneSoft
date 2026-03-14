package in.onesoft.pos.repository;

import in.onesoft.pos.id.IdGenerator;
import in.onesoft.pos.model.Company;
import in.onesoft.pos.routing.ScopeRouter;
import in.onesoft.pos.jooq.tables.Companies;
import in.onesoft.pos.jooq.tables.records.CompaniesRecord;
import org.jooq.DSLContext;

import java.util.List;

public class CompanyRepository {

    private static final Companies T = Companies.COMPANIES;

    // எல்லா companies list
    public List<Company> findAll(String scopeId) {
        DSLContext ctx = ScopeRouter.routeByScopeId(scopeId);
        return ctx.selectFrom(T)
                .where(T.IS_ACTIVE.eq(true))
                .fetchInto(Company.class);
    }

    // ID-ல ஒரு company
    public Company findById(String id) {
        String scopeId = IdGenerator.extractScopeId(id);
        DSLContext ctx = ScopeRouter.routeByScopeId(scopeId);
        return ctx.selectFrom(T)
                .where(T.ID.eq(id))
                .fetchOneInto(Company.class);
    }

    // புது company create
    public Company create(Company company) {
        // 19-digit ID generate
        String scopeId = IdGenerator.formatScopeId(1); // default scope 1
        String newId = IdGenerator.generate(scopeId);

        company.id = newId;
        company.scopeId = scopeId;

        DSLContext ctx = ScopeRouter.routeByScopeId(scopeId);

        CompaniesRecord record = ctx
                .insertInto(T)
                .set(T.ID, company.id)
                .set(T.SCOPE_ID, company.scopeId)
                .set(T.NAME, company.name)
                .set(T.GSTIN, company.gstin)
                .set(T.PHONE, company.phone)
                .set(T.EMAIL, company.email)
                .set(T.PLAN_TYPE, company.planType != null ? company.planType : "BASIC")
                .returning()
                .fetchOne();

        return record.into(Company.class);
    }
}