package liga.store.warehouseservice.core.service.impl;

import liga.store.warehouseservice.core.service.UserService;
import liga.store.warehouseservice.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public UserDto findById(Long id) {
        return null;
    }

    @Override
    public List<UserDto> findByListId(List<Long> listId) {
        return null;
    }

    @Override
    public void insert(UserDto userDto) {

    }

    @Override
    public void insertAll(List<UserDto> userDtos) {

    }

    @Override
    public void updateById(UserDto userDto) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
