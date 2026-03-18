package in.onesoft.pos.repository;

import in.onesoft.pos.jooq.tables.Products;
import in.onesoft.pos.jooq.tables.records.ProductsRecord;
import in.onesoft.pos.model.Product;

public class ProductRepository extends BaseRepository<ProductsRecord, Product> {
    public ProductRepository() {
        super(Products.PRODUCTS, Products.PRODUCTS.ID, Products.PRODUCTS.COMPANY_ID, Product.class);
    }
}