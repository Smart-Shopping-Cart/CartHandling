package service.models.interfaces.dto;

public interface IProductDTO {
    IProductDTO id(String id);

    String getId();

    void setId(String id);

    IProductDTO price(String price);

    String getPrice();

    void setPrice(String price);

    String getName();

    void setName(String name);
}
