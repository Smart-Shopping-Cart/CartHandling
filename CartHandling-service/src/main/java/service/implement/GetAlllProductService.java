package service.implement;

import _generated_sources_openapi_model.Product;
import db.service.interfaces.IDBProductService;
import service.interfaces.IGetAlllProductService;

import javax.inject.Inject;
import java.util.List;

public class GetAlllProductService implements IGetAlllProductService
{
 @Inject
    IDBProductService productService;

    @Override
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }

}
