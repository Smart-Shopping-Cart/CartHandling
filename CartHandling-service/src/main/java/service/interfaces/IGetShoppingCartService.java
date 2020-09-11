package service.interfaces;

import _generated_sources_openapi_model.Product;
import service.models.interfaces.dto.ICartDTO;

public interface IGetShoppingCartService
{

    ICartDTO getShoppingCart(String customerID);

}
