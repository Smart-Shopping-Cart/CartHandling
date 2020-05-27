package service.mappers;

import _generated_sources_openapi_model.Customer;
import _generated_sources_openapi_model.Product;
import org.mapstruct.Mapper;
import service.config.ServiceFactory;
import service.models.interfaces.dto.ICustomerDTO;

@Mapper(uses = ServiceFactory.class)

public interface IMapCustomer
{
    Customer mapCustomerDTOToEntity(ICustomerDTO customerDTO);
    ICustomerDTO mapCustomerEntityToDTO(Customer  customer );
}
