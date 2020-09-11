package service.interfaces;

import _generated_sources_openapi_model.Product;
import service.models.implement.dto.ProductDTO;
import service.models.interfaces.dto.IProductDTO;

public interface IGetProductService {
    Product getProduct(String productName);
}
