package service.models.interfaces.dto;

import service.models.implement.dto.ProductDTO;

public interface IProductDTO {
    ProductDTO id(String id);

    String getId();

    void setId(String id);

    ProductDTO price(String price);

    String getPrice();

    void setPrice(String price);

    String toIndentedString(Object o);
}
