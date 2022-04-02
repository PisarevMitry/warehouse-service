package liga.store.warehouseservice.core;

import liga.store.warehouseservice.core.model.entity.UserRole;
import liga.store.warehouseservice.core.service.impl.UserServiceImpl;
import liga.store.warehouseservice.dto.UserDto;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Init {

    private final UserServiceImpl userService;

    public Init(UserServiceImpl userService) {
        this.userService = userService;
    }


    @PostConstruct
    public void init() {

        userService.insert(new UserDto(null, "d.pisarev.03@mail.ru", "1111", UserRole.ROLE_OWNER.toString()));
        userService.insert(new UserDto(null, "Galina", "2222", UserRole.ROLE_ADMIN.toString()));
        userService.insert(new UserDto(null, "random", "3333", UserRole.ROLE_USER.toString()));
    }

    @PreDestroy
    void destroy() {
        userService.deleteById(userService.findByLogin("d.pisarev.03@mail.ru").getId());
        userService.deleteById(userService.findByLogin("Galina").getId());
        userService.deleteById(userService.findByLogin("random").getId());

    }
}

