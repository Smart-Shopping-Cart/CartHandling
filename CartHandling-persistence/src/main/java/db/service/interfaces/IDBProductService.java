package db.service.interfaces;

import _generated_sources_openapi_model.Product;

public interface IDBProductService {


    Product createProduct(Product product);

    Product getProduct(String id);

    long deleteProduct(String id);

    Product updateProduct(Product product);
}
