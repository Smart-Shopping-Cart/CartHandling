package db.service.interfaces;

import _generated_sources_openapi_model.Camera;

public interface IDBCameraService {

    Camera createCamera(Camera camera);

    Camera getCamera(String id);

    long deleteCamera(String id);

    Camera updateCamera(Camera camera);

    Camera createCamera(String cameraip);

    Camera getCameraByIp(String ip);
}
