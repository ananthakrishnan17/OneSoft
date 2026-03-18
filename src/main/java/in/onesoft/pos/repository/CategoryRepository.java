package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.Categories;
import in.onesoft.pos.jooq.tables.records.CategoriesRecord;
import in.onesoft.pos.model.Category;

public class CategoryRepository extends BaseRepository<CategoriesRecord, Category> {
    public CategoryRepository() {
        super(Categories.CATEGORIES, Categories.CATEGORIES.ID, Categories.CATEGORIES.COMPANY_ID, Category.class);
    }
}