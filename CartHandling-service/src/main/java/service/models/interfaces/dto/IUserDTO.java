package service.models.interfaces.dto;

public interface IUserDTO {
    String getName();

    void setName(String name);

    IUserDTO password(String password);

    String getPassword();

    void setPassword(String password);

    IUserDTO id(String id);

    String getId();

    void setId(String id);
}
