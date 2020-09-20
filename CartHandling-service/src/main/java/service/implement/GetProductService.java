package service.implement;

import _generated_sources_openapi_model.Product;
import db.service.interfaces.IDBProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import service.interfaces.IGetProductService;
import service.mappers.IMapProduct;
import service.models.implement.dto.ProductDTO;
import service.models.interfaces.dto.IProductDTO;

import javax.inject.Inject;

public class GetProductService implements IGetProductService
{
    @Inject
    IDBProductService idbProductService;
    @Inject
    IMapProduct mapProduct;

    @Override
    public Product getProduct(String productName)
    {
        Product p1=idbProductService.getProduct(productName);
        if(p1==null)
        {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,"There is no such product with this ID  "+ productName);
        }
        return p1;
    }

}
