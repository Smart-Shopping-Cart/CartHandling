package api.security.implement;

import _generated_sources_openapi_model.Customer;
import _generated_sources_openapi_model.Token;
import _generated_sources_openapi_model.User;
import api.security.interfaces.ITokenService;
import com.fasterxml.jackson.databind.ObjectMapper;
import db.service.interfaces.IDBUserService;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TokenService implements ITokenService {
    @Value("${jwt.secret}")
    private String secret;

    @Inject
    IDBUserService idbuserService;

    @Override
    public Token verifyAuthenticationHeader(String authorization) {
        if (authorization == null || !authorization.startsWith("Bearer "))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Bearer Authentication must be used");
        String tokenString = authorization.replaceFirst("Bearer ", "");
        Token token = verifyJwt(tokenString);
        Date tokenDate = new Date();
        if(StringUtils.isEmpty(idbuserService.getUser(token.getUserId())))
            throw new IllegalStateException("Could not Create JWT token: user doesnt exist");
        try {
            tokenDate = new SimpleDateFormat().parse(token.getCreationDate());
            tokenDate.setTime(60*60*1000*3);
        }catch (Exception e){
            Logger.getAnonymousLogger().log(Level.WARNING,"invalid date at token verification");
        }
        if(new Date().after(tokenDate))
            throw new IllegalStateException("Could not verify JWT token: token expired");
        return token;
    }

    private Token verifyJwt(String tokenString) {
        Token token = new Token();
        try {
             token.setUserId(Jwts.parser()
                     .setSigningKey(secret)
                     .parseClaimsJws(tokenString)
                     .getBody()
                     .get("userId", String.class));
             token.setCustomerId(Jwts.parser()
                     .setSigningKey(secret)
                     .parseClaimsJws(tokenString)
                     .getBody()
                     .get("customerId", String.class));
             token.setCreationDate(Jwts.parser()
                     .setSigningKey(secret)
                     .parseClaimsJws(tokenString)
                     .getBody()
                     .get("createDate", String.class));
             token.setShoppingDate(Jwts.parser()
                     .setSigningKey(secret)
                     .parseClaimsJws(tokenString)
                     .getBody()
                     .get("shoppingDate", String.class));
            return token;
        } catch (JwtException e) {
            throw new IllegalStateException("Could not verify JWT token", e);
        }
    }
    @Override
    public String buildJwtToken(User user)
    {
        User userFromDb=idbuserService.getUser(user);
        if(Objects.isNull(userFromDb))
            throw new IllegalStateException("Could not Create JWT token: user doesnt exist");
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS512, secret)
                .setPayload(new ObjectMapper().createObjectNode()
                        .put("userId", userFromDb.getId())
                        .put("customerId", "")
                        .put("createDate", new Date().toString())
                        .put("shoppingDate", "")
                        .toString())
                .compact();
        return token;
    }
    @Override
    public String BindToken(String tokenString, Customer customer) {
        Token token = verifyJwt(tokenString);
        tokenString = Jwts.builder().signWith(SignatureAlgorithm.HS512, secret)
                .setPayload(new ObjectMapper().createObjectNode()
                        .put("userId", customer.getUserId())
                        .put("customerId",customer.getId())
                        .put("createDate", token.getCreationDate())
                        .put("shoppingDate", new Date().toString())
                        .toString())
                .compact();
        return tokenString;
    }
}
