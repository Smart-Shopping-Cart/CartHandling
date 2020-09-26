package tests.mappers;

import _generated_sources_openapi_model.Camera;
import org.junit.Assert;
import org.junit.Test;
import service.mappers.IMapCamera;
import service.models.interfaces.dto.ICameraDTO;
import tests.base.BaseTests;

import javax.inject.Inject;
import java.net.URL;

public class MapStructTests extends BaseTests {

    @Inject
    IMapCamera mapCamera;

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
}
