package service.implement;

import db.service.implement.DBCameraService;
import db.service.interfaces.IDBCameraService;
import db.service.interfaces.IDBCustomertService;
import db.service.interfaces.IDBShoppingCartService;
import db.service.interfaces.IDBUserService;
import service.interfaces.IBindService;
import service.interfaces.IRemoveProductService;
import service.mappers.IMapCamera;
import service.mappers.IMapCart;
import service.mappers.IMapUser;
import service.models.implement.dto.CameraDTO;
import service.models.interfaces.dto.ICameraDTO;
import service.models.interfaces.dto.ICartDTO;
import service.models.interfaces.dto.IUserDTO;

import javax.inject.Inject;

public class BindService implements IBindService{
    @Inject
    IDBCameraService  DBcameraService;
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


    @Override
    public void bind(String cameraIp, String userID)
    {
    ICameraDTO cameraDTO=mapCamera.mapCameraEntityToDTO(DBcameraService.createCamera(cameraIp));
    IUserDTO userDTO=mapUser.mapUserEntityToDTO(DBuserService.getUser(userID));
    ICartDTO cartDTO=mapCart.mapCartEntityToDTO(DBshoppingCartService.createNewCart(""));
    //add to customer db---create new customer
    }

}
