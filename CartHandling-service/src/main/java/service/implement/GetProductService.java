package service.implement;

import _generated_sources_openapi_model.Product;
import db.service.interfaces.IDBProductService;
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
        return idbProductService.getProduct(productName);
    }

}
