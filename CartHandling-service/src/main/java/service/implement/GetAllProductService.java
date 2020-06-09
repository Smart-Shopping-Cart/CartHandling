package service.implement;

import _generated_sources_openapi_model.Product;
import db.service.interfaces.IDBProductService;
import service.interfaces.IGetAllProductService;

import javax.inject.Inject;
import java.util.List;

public class GetAllProductService implements IGetAllProductService
{
 @Inject
    IDBProductService productService;

    @Override
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }

}
