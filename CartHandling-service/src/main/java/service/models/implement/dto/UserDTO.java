package service.models.implement.dto;

import service.models.interfaces.dto.IUserDTO;

import java.util.Objects;

public class UserDTO implements IUserDTO {

    private String name;

    private String password;

    private String id;

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override

    public IUserDTO password(String password) {
        this.password = password;
        return this;
    }

    @Override

    public String getPassword() {
        return password;
    }
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    @Override

    public IUserDTO id(String id) {
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
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDTO user = (UserDTO) o;
        return Objects.equals(this.name, user.name) &&
                Objects.equals(this.password, user.password) &&
                Objects.equals(this.id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class User {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
