package service.interfaces;

import service.models.interfaces.dto.IUserDTO;

public interface ISignUpService {
    void createUser(IUserDTO user);
}
