package service.implement;

import db.service.interfaces.IDBCameraService;
import db.service.interfaces.IDBCustomertService;
import db.service.interfaces.IDBShoppingCartService;
import db.service.interfaces.IDBUserService;
import service.interfaces.IBindService;
import service.mappers.IMapCamera;
import service.mappers.IMapCart;
import service.mappers.IMapCustomer;
import service.mappers.IMapUser;
import service.models.implement.dto.CustomerDTO;
import service.models.interfaces.dto.ICameraDTO;
import service.models.interfaces.dto.ICartDTO;
import service.models.interfaces.dto.ICustomerDTO;
import service.models.interfaces.dto.IUserDTO;

import javax.inject.Inject;

public class BindService implements IBindService {
    @Inject
    IDBCameraService DBcameraService;
    @Inject
    IDBUserService DBuserService;
    @Inject
    IDBShoppingCartService DBshoppingCartService;
    @Inject
    IDBCustomertService DBcustomertService;
    @Inject
    IMapUser mapUser;
    @Inject
    IMapCamera mapCamera;
    @Inject
    IMapCart mapCart;
    @Inject
    IMapCustomer mapCustomer;

    @Inject
    recognition.implementation.RecognitionGateWay RecognitionGateWay;

    @Override
    public String bind(String cameraIp, String userID) {
        ICameraDTO cameraDTO = mapCamera.mapCameraEntityToDTO(DBcameraService.createCamera(cameraIp));
        IUserDTO userDTO = mapUser.mapUserEntityToDTO(DBuserService.getUser(userID));
        ICartDTO cartDTO = mapCart.mapCartEntityToDTO(DBshoppingCartService.createNewCart());
        ICustomerDTO customer = new CustomerDTO();
        customer.setCamera(cameraDTO.getId());
        customer.setCartId(cartDTO.getId());
        customer.setUserId(userDTO.getId());
        ICustomerDTO c1 = mapCustomer.mapCustomerEntityToDTO(DBcustomertService.createCustomer(mapCustomer.mapCustomerDTOToEntity(customer)));
        RecognitionGateWay.addCamera(mapCamera.mapCameraDTOToEntity(cameraDTO));
        return c1.getId();
    }
}
