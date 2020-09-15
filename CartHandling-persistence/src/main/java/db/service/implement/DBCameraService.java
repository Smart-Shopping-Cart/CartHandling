package db.service.implement;

import _generated_sources_openapi_model.Camera;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import db.service.interfaces.IDBCameraService;
import org.bson.types.ObjectId;

import javax.inject.Inject;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.ReturnDocument.AFTER;

public class DBCameraService implements IDBCameraService {

    @Inject
    private MongoCollection<Camera> cameraTable;

    @Override
    public Camera createCamera(Camera camera){
        camera.setId(new ObjectId().toHexString());
        cameraTable.insertOne(camera);
        return camera;
    }
    public Camera createCamera(String cameraip){
        Camera camera=new Camera();
        camera.setIp(cameraip);
        camera.setId(new ObjectId().toHexString());
        cameraTable.insertOne(camera);
        return camera;
    }

    @Override
    public Camera getCamera(String id) {
        return cameraTable.find(eq("_id", new ObjectId(id).toHexString())).first();
    }

    @Override
    public Camera getCameraByIp(String ip) {
        return cameraTable.find(eq("ip", ip)).first();}

    @Override
    public long deleteCamera(String id) {
        return cameraTable.deleteOne(eq("_id", new ObjectId(id).toHexString())).getDeletedCount();
    }

    @Override
    public Camera updateCamera(Camera camera) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions().returnDocument(AFTER);
        return cameraTable.findOneAndReplace(eq("_id", camera.getId()), camera, options);
    }
}
