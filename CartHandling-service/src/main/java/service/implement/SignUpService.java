package service.implement;

import db.service.interfaces.IDBUserService;
import service.interfaces.ISignUpService;
import service.mappers.IMapUser;
import service.models.interfaces.dto.IUserDTO;

import javax.inject.Inject;

public class SignUpService implements ISignUpService {

    @Inject
    IDBUserService idbUserService;
    @Inject
    IMapUser mapUser;

    @Override
    public void createUser(IUserDTO user){
        idbUserService.createUser(mapUser.mapUserDTOToEntity(user));
    }
}
