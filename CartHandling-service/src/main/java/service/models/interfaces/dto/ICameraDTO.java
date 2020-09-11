package service.models.interfaces.dto;

import service.models.implement.dto.CameraDTO;

public interface ICameraDTO {
    String getId();

    void setId(String id);

    CameraDTO ip(String ip);

    String getIp();

    void setIp(String ip);
}
