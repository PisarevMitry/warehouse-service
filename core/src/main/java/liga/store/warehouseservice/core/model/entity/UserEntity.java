package liga.store.warehouseservice.core.model.entity;

import lombok.Data;

@Data
public class UserEntity {
    private Long id;
    private String login;
    private String password;
    private String roleId;
}


