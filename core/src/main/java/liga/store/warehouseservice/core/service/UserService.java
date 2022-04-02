package liga.store.warehouseservice.core.service;

import liga.store.warehouseservice.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends CrudService<UserDto>, UserDetailsService {
    UserDto findByLogin(String login);
}
