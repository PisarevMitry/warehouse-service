package liga.store.warehouseservice.core.model.entity;

import org.springframework.security.core.GrantedAuthority;


public enum UserRole implements GrantedAuthority {
    ROLE_OWNER, ROLE_ADMIN, ROLE_USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
