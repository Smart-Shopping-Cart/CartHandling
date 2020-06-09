package resource.delegates.implement;

import _generated_sources_openapi_model.Cart;
import api.controllers.CartHandlingController.IGetShoppingCartDelegate;
import org.springframework.http.ResponseEntity;
import service.interfaces.IGetShoppingCartService;
import service.mappers.IMapCart;

import javax.inject.Inject;

public class GetShoppingCartDelegate implements IGetShoppingCartDelegate {

@Inject
    IGetShoppingCartService getShoppingCartService;
    @Inject
    IMapCart mapCart;

    @Override
    public ResponseEntity<Cart> execute(String customerID)
    {
        mapCart.mapCartDTOToEntity(getShoppingCartService.getShoppingCart(customerID));
        return null;
    }
}
