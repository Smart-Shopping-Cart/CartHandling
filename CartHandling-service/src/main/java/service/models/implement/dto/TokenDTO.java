package service.models.implement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import service.models.interfaces.dto.ITokenDTO;

public class TokenDTO implements ITokenDTO {
    @JsonProperty("tokenId")
    private String tokenId;

    @JsonProperty("expiryDate")
    private String expiryDate;

    @JsonProperty("productionDate")
    private String productionDate;
    @Override
    public String getTokenId() {
        return tokenId;
    }
    @Override
    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
    @Override
    public String getExpiryDate() {
        return expiryDate;
    }
    @Override
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    @Override
    public String getProductionDate() {
        return productionDate;
    }
    @Override
    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }
}
