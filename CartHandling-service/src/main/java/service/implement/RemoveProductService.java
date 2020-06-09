package service.implement;

import _generated_sources_openapi_model.Product;
import db.service.interfaces.IDBCustomertService;
import db.service.interfaces.IDBProductService;
import db.service.interfaces.IDBShoppingCartService;
import service.interfaces.IRemoveProductService;
import service.mappers.IMapCart;
import service.mappers.IMapCustomer;
import service.mappers.IMapProduct;
import service.models.interfaces.dto.ICartDTO;
import service.models.interfaces.dto.ICustomerDTO;
import service.models.interfaces.dto.IProductDTO;

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
    @Inject
    IMapProduct mapProduct;


    @Override
    public void removeProduct(String cameraId, String productName)
    {
        ICustomerDTO customerDTO= mapCustomer.mapCustomerEntityToDTO(idbCustomertService.getCustomerByCameraID(cameraId));
        ICartDTO cartDTO=mapCart.mapCartEntityToDTO(idbShoppingCartService.getCart(customerDTO.getCartId()));
        IProductDTO productDTO=mapProduct.mapProductEntityToDTO(idbProductService.getProduct(productName));
        cartDTO.removeProductsItem(mapProduct.mapProductDTOToEntity(productDTO));
        idbShoppingCartService.updateCart(mapCart.mapCartDTOToEntity(cartDTO));

    }
}

