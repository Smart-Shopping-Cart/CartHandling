package recognition.implementation;

import _generated_sources_openapi_api.CameraApi;
import _generated_sources_openapi_model.Camera;

import javax.inject.Inject;
import java.util.List;

public class RecognitionGateWay {
    @Inject
    CameraApi cameraApi;

    public void addCamera(Camera camera){
        cameraApi.addCamera(camera);
    }

    public void removeCamera(String cameraIp){
        cameraApi.removeCamera(cameraIp);
    }

    public List<Camera> getAllCameras(){
        return cameraApi.getCameras();
    }
}
