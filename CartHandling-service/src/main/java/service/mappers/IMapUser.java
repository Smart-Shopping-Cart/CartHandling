package service.mappers;

import _generated_sources_openapi_model.User;
import org.mapstruct.Mapper;
import service.config.ServiceFactory;
import service.models.interfaces.dto.IUserDTO;

@Mapper(uses = ServiceFactory.class)
public interface IMapUser {
    User mapUserDTOToEntity(IUserDTO token);
    IUserDTO mapUserEntityToDTO(User token);
}
