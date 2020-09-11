package service.models.implement.dto;

import _generated_sources_openapi_model.Camera;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import service.models.interfaces.dto.ICameraDTO;

import java.util.Objects;

public class CameraDTO implements ICameraDTO {

    private String id;

    private String ip;

    public CameraDTO id(String id) {
        this.id = id;
        return this;
    }


    @Override
    public String getId() {
        return id;
    }
    @Override

    public void setId(String id) {
        this.id = id;
    }
    @Override

    public CameraDTO ip(String ip) {
        this.ip = ip;
        return this;
    }
    @Override

    public String getIp() {
        return ip;
    }
    @Override

    public void setIp(String ip) {
        this.ip = ip;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CameraDTO camera = (CameraDTO) o;
        return Objects.equals(this.id, camera.id) &&
                Objects.equals(this.ip, camera.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ip);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Camera {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    ip: ").append(toIndentedString(ip)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

