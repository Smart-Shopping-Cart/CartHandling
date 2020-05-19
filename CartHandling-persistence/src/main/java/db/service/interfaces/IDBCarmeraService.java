package db.service.interfaces;

import _generated_sources_openapi_model.Camera;

public interface IDBCarmeraService {

    Camera createCamera(Camera camera);

    Camera getCamera(String id);

    long deleteCamera(String id);

    Camera updateCamera(Camera camera);
}
