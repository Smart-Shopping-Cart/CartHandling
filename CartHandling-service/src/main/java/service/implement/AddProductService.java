package service.implement;

import db.service.interfaces.IDBCameraService;
import db.service.interfaces.IDBCustomertService;
import db.service.interfaces.IDBProductService;
import db.service.interfaces.IDBShoppingCartService;
import service.interfaces.IAddProductService;
import service.mappers.IMapCamera;
import service.mappers.IMapCart;
import service.mappers.IMapCustomer;
import service.mappers.IMapProduct;
import service.models.interfaces.dto.ICameraDTO;
import service.models.interfaces.dto.ICartDTO;
import service.models.interfaces.dto.ICustomerDTO;
import service.models.interfaces.dto.IProductDTO;

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
    IDBCameraService idbCameraService;
    @Inject
    IMapCustomer mapCustomer;
    @Inject
    IMapCart mapCart;
    @Inject
    IMapProduct mapProduct;
    @Inject
    IMapCamera mapCamera;


    @Override
    public void addProduct(String cameraIp,String productName) {
        ICameraDTO cameraDTO = mapCamera.mapCameraEntityToDTO(idbCameraService.getCameraByIp(cameraIp));
        ICustomerDTO customerDTO = mapCustomer.mapCustomerEntityToDTO(idbCustomertService.getCustomerByCameraID(cameraDTO.getId()));
        ICartDTO cartDTO = mapCart.mapCartEntityToDTO(idbShoppingCartService.getCart(customerDTO.getCartId()));
        IProductDTO productDTO = mapProduct.mapProductEntityToDTO(idbProductService.getProductByName(productName));
        cartDTO.addProductsItem(mapProduct.mapProductDTOToEntity(productDTO));
        idbShoppingCartService.updateCart(mapCart.mapCartDTOToEntity(cartDTO));
    }
}
