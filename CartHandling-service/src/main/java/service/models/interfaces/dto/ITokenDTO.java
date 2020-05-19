package service.models.interfaces.dto;

public interface ITokenDTO {
    String getTokenId();

    void setTokenId(String tokenId);

    String getExpiryDate();

    void setExpiryDate(String expiryDate);

    String getProductionDate();

    void setProductionDate(String productionDate);
}
