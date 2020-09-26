package tests.mappers;

import _generated_sources_openapi_model.*;
import org.junit.Assert;
import org.junit.Test;
import service.mappers.*;
import service.models.interfaces.dto.*;
import tests.base.BaseTests;

import javax.inject.Inject;
import java.net.URL;

public class MapStructTests extends BaseTests {

    @Inject
    IMapCamera mapCamera;

    @Inject
    IMapCart mapCart;

    @Inject
    IMapProduct mapProduct;

    @Inject
    IMapUser mapUser;

    @Inject
    IMapCustomer mapCustomer;

//    @MockBean
//    IDBCameraService DBcameraService;

//    @Before
//    public void setup(){
//        Camera camera = new Camera();
//        camera.setId("0");
//        camera.setIp("0");
//        when(DBcameraService.createCamera(any(String.class))).thenReturn(camera);
//    }


    @Test
    public void mappingCameraResourceToDto()
    {
        URL resource = getClass().getClassLoader().getResource("camera.json");
        Camera camera = null;
        try{
            camera = objectMapper.readValue(resource,Camera.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ICameraDTO cameraDTO = mapCamera.mapCameraEntityToDTO(camera);
        Assert.assertNotNull(cameraDTO);
        Assert.assertEquals(camera.getId(),cameraDTO.getId());
        Assert.assertEquals(camera.getIp(),cameraDTO.getIp());
    }
    @Test
    public void mappingProductResourceToDto()
    {
        URL resource = getClass().getClassLoader().getResource("product.json");
        Product product = null;
        try{
            product = objectMapper.readValue(resource,Product.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        IProductDTO productDTO = mapProduct.mapProductEntityToDTO(product);
        Assert.assertNotNull(productDTO);
        Assert.assertEquals(product.getId(),productDTO.getId());
        Assert.assertEquals(product.getName(),productDTO.getName());
        Assert.assertEquals(product.getPrice(),productDTO.getPrice());

    }
    @Test
    public void mappingCartResourceToDto()
    {
        URL resource = getClass().getClassLoader().getResource("cart.json");
        Cart cart = null;
        try{
            cart = objectMapper.readValue(resource,Cart.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ICartDTO cartDTO = mapCart.mapCartEntityToDTO(cart);
        Assert.assertNotNull(cartDTO);
        Assert.assertEquals(cart.getId(),cartDTO.getId());
        Assert.assertEquals(cart.getTotalPrice(),cartDTO.getTotalPrice());

    }
    @Test
    public void mappingUserResourceToDto()
    {
        URL resource = getClass().getClassLoader().getResource("user.json");
        User user = null;
        try{
            user = objectMapper.readValue(resource,User.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        IUserDTO userDTO = mapUser.mapUserEntityToDTO(user);
        Assert.assertNotNull(userDTO);
        Assert.assertEquals(user.getId(),userDTO.getId());
        Assert.assertEquals(user.getPassword(),userDTO.getPassword());
        Assert.assertEquals(user.getName(),userDTO.getName());

    }
    @Test
    public void mappingCustomerResourceToDto()
    {
        URL resource = getClass().getClassLoader().getResource("customer.json");
        Customer customer = null;
        try{
            customer = objectMapper.readValue(resource,Customer.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        ICustomerDTO customerDTO = mapCustomer.mapCustomerEntityToDTO(customer);
        Assert.assertNotNull(customerDTO);
        Assert.assertEquals(customer.getId(),customerDTO.getId());
        Assert.assertEquals(customer.getUserId(),customerDTO.getUserId());
        Assert.assertEquals(customer.getCamera(),customerDTO.getCamera());
        Assert.assertEquals(customer.getCartId(),customerDTO.getCartId());


    }


}
