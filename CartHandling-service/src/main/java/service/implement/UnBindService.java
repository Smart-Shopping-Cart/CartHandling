package service.implement;

import db.service.interfaces.IDBCameraService;
import db.service.interfaces.IDBCustomertService;
import service.interfaces.IUnBindService;
import service.mappers.IMapCamera;
import service.mappers.IMapCustomer;
import service.models.interfaces.dto.ICameraDTO;
import service.models.interfaces.dto.ICustomerDTO;

import javax.inject.Inject;

public class UnBindService implements IUnBindService {

    @Inject
    recognition.implementation.RecognitionGateWay RecognitionGateWay;

    @Inject
    IMapCustomer mapCustomer;

    @Inject
    IDBCustomertService idbCustomertService;

    @Inject
    IMapCamera mapCamera;
    @Inject
    IDBCameraService DBCameraService;


    @Override
    public void unBind(String customerID) {
        ICustomerDTO customerDTO= mapCustomer.mapCustomerEntityToDTO(idbCustomertService.getCustomer(customerID));
        ICameraDTO cameraDTO = mapCamera.mapCameraEntityToDTO(DBCameraService.getCamera(customerDTO.getCamera()));
        RecognitionGateWay.removeCamera(cameraDTO.getId());
    }
}
