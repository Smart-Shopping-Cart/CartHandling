package service.implement;

import _generated_sources_openapi_model.Product;
import db.service.interfaces.IDBCustomertService;
import db.service.interfaces.IDBProductService;
import db.service.interfaces.IDBShoppingCartService;
import service.interfaces.IRemoveProductService;
import service.mappers.IMapCart;
import service.mappers.IMapCustomer;
import service.models.interfaces.dto.ICartDTO;
import service.models.interfaces.dto.ICustomerDTO;

import javax.inject.Inject;

public class RemoveProductService implements IRemoveProductService
{

    @Inject
    IDBProductService idbProductService;
    @Inject
    IDBCustomertService idbCustomertService;
    @Inject
    IDBShoppingCartService idbShoppingCartService;
    @Inject
    IMapCustomer mapCustomer;
    @Inject
    IMapCart mapCart;

    @Override
    public void removeProduct(String productName, String cameraId)
    {
        ICustomerDTO customerDTO= mapCustomer.mapCustomerEntityToDTO(idbCustomertService.getCustomerByCameraID(cameraId));
        ICartDTO cartDTO=mapCart.mapCartEntityToDTO(idbShoppingCartService.getCart(customerDTO.getCartId()));
        Product product=idbProductService.getProduct(productName);
        cartDTO.addProductsItem(product);
        idbShoppingCartService.updateCart(mapCart.mapCartDTOToEntity(cartDTO));

    }
}

