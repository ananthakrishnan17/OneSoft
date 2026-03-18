package in.onesoft.pos.repository;

import in.onesoft.pos.model.Company;
import in.onesoft.pos.jooq.tables.Companies;
import in.onesoft.pos.jooq.tables.records.CompaniesRecord;

public class CompanyRepository extends BaseRepository<CompaniesRecord, Company> {
    public CompanyRepository() {
        // Company table doesn't have a parent company_id, so we pass null for it
        super(Companies.COMPANIES, Companies.COMPANIES.ID, null, Company.class);
    }
}