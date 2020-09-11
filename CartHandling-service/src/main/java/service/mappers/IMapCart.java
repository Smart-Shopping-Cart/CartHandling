package service.mappers;

import _generated_sources_openapi_model.Cart;
import org.mapstruct.Mapper;
import service.config.ServiceFactory;
import service.models.interfaces.dto.ICartDTO;
@Mapper(uses = ServiceFactory.class)

public interface IMapCart
{
    Cart mapCartDTOToEntity(ICartDTO cartDTO);
    ICartDTO mapCartEntityToDTO(Cart cart);

}
