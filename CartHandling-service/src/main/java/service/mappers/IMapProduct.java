package service.mappers;

import _generated_sources_openapi_model.Product;
import org.mapstruct.Mapper;
import service.config.ServiceFactory;
import service.models.interfaces.dto.IProductDTO;

@Mapper(uses = ServiceFactory.class)
public interface IMapProduct {

    Product mapProductDTOToEntity(IProductDTO productDTO);
    IProductDTO mapProductEntityToDTO(Product product);
}
