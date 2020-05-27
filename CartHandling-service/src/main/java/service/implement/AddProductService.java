package service.implement;

import _generated_sources_openapi_model.Customer;
import _generated_sources_openapi_model.Product;
import db.service.interfaces.IDBCustomertService;
import db.service.interfaces.IDBProductService;
import db.service.interfaces.IDBShoppingCartService;
import db.service.interfaces.IDBUserService;
import service.interfaces.IAddProductService;
import service.mappers.IMapCart;
import service.mappers.IMapCustomer;
import service.mappers.IMapUser;
import service.models.interfaces.dto.ICartDTO;
import service.models.interfaces.dto.ICustomerDTO;

import javax.inject.Inject;

public class AddProductService implements IAddProductService
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
    public void addProduct(String cameraId,String productName)
    {
       ICustomerDTO customerDTO= mapCustomer.mapCustomerEntityToDTO(idbCustomertService.getCustomerByCameraID(cameraId));
       ICartDTO cartDTO=mapCart.mapCartEntityToDTO(idbShoppingCartService.getCart(customerDTO.getCartId()));
       Product product=idbProductService.getProduct(productName);
       cartDTO.addProductsItem(product);
       idbShoppingCartService.updateCart(mapCart.mapCartDTOToEntity(cartDTO));

    }
}
