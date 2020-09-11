package api.security.interfaces;

import _generated_sources_openapi_model.Customer;
import _generated_sources_openapi_model.Token;
import _generated_sources_openapi_model.User;

public interface ITokenService {
    Token verifyAuthenticationHeader(String authorization);

    String buildJwtToken(User user);



    String BindToken(String tokenString, String customerId);
}
