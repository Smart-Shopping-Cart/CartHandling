package db.service.interfaces;

import _generated_sources_openapi_model.Product;

import java.util.List;

public interface IDBProductService {


    Product createProduct(Product product);

    Product getProduct(String id);

    long deleteProduct(String id);

    Product updateProduct(Product product);

    List<Product> getAllProducts();
}
