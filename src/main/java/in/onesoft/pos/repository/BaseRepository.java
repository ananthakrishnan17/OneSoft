package in.onesoft.pos.repository;

import in.onesoft.pos.db.Database;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UpdatableRecord;

import java.util.List;

/**
 * Generic Repository to handle CRUD operations for all jOOQ generated tables
 * automatically.
 */
public abstract class BaseRepository<R extends UpdatableRecord<R>, P> {

    protected final Table<R> table;
    protected final TableField<R, Long> idField;
    protected final TableField<R, Long> companyIdField;
    protected final Class<P> pojoClass;

    public BaseRepository(Table<R> table, TableField<R, Long> idField, TableField<R, Long> companyIdField,
            Class<P> pojoClass) {
        this.table = table;
        this.idField = idField;
        this.companyIdField = companyIdField;
        this.pojoClass = pojoClass;
    }

    public P findById(Long companyId, Long id) {
        var query = Database.ctx().selectFrom(table).where(idField.eq(id));
        if (companyIdField != null && companyId != null) {
            query.and(companyIdField.eq(companyId));
        }
        return query.fetchOneInto(pojoClass);
    }

    public List<P> findAll(Long companyId) {
        var query = Database.ctx().selectFrom(table);
        if (companyIdField != null && companyId != null) {
            query.where(companyIdField.eq(companyId));
        }
        return query.fetchInto(pojoClass);
    }

    public P create(P pojo) {
        R record = Database.ctx().newRecord(table, pojo);
        record.insert();
        return record.into(pojoClass);
    }

    public P update(Long companyId, Long id, P pojo) {
        R record = Database.ctx().newRecord(table, pojo);
        record.set(idField, id);
        if (companyIdField != null && companyId != null) {
            record.set(companyIdField, companyId);
        }
        record.update();
        return record.into(pojoClass);
    }

    public boolean delete(Long companyId, Long id) {
        var query = Database.ctx().deleteFrom(table).where(idField.eq(id));
        if (companyIdField != null && companyId != null) {
            query.and(companyIdField.eq(companyId));
        }
        return query.execute() > 0;
    }
}