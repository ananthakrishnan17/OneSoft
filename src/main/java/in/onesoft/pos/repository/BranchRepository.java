package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.Branches;
import in.onesoft.pos.jooq.tables.records.BranchesRecord;
import in.onesoft.pos.model.Branch; // Map this to your jOOQ-generated POJO

public class BranchRepository extends BaseRepository<BranchesRecord, Branch> {
    public BranchRepository() {
        super(Branches.BRANCHES, Branches.BRANCHES.ID, Branches.BRANCHES.COMPANY_ID, Branch.class);
    }
}