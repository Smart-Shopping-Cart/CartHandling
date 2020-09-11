package service.implement;

import db.service.interfaces.IDBCustomertService;
import db.service.interfaces.IDBShoppingCartService;
import service.interfaces.IGetShoppingCartService;
import service.mappers.IMapCart;
import service.mappers.IMapCustomer;
import service.models.interfaces.dto.ICartDTO;
import service.models.interfaces.dto.ICustomerDTO;

import javax.inject.Inject;

public class GetShoppingCartService implements IGetShoppingCartService {
    @Inject
    IDBCustomertService idbCustomertService;
    @Inject
    IDBShoppingCartService idbShoppingCartService;
    @Inject
    IMapCustomer mapCustomer;
    @Inject
    IMapCart mapCart;

    @Override
    public ICartDTO getShoppingCart(String customerID)
    {


        ICustomerDTO customerDTO= mapCustomer.mapCustomerEntityToDTO(idbCustomertService.getCustomer(customerID));
        ICartDTO cartDTO=mapCart.mapCartEntityToDTO(idbShoppingCartService.getCart(customerDTO.getCartId()));
        return cartDTO;
    }

}
