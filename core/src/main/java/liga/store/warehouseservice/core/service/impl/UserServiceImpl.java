package liga.store.warehouseservice.core.service.impl;

import liga.store.warehouseservice.core.model.entity.UserEntity;
import liga.store.warehouseservice.core.repository.UserRepository;
import liga.store.warehouseservice.core.service.UserService;
import liga.store.warehouseservice.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = new BCryptPasswordEncoder(12);
        ;
    }

    @Override
    public List<UserDto> findAll() {
        List<UserEntity> userEntityList = userRepository.findAll();
        return userEntityList.stream().map(el -> modelMapper.map(el, UserDto.class)).collect(Collectors.toList());
    }


    @Override
    public UserDto findById(Long id) {
        UserEntity userEntity = userRepository.findById(id);
        return modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public List<UserDto> findByListId(List<Long> listId) {
        List<UserEntity> userEntityList = userRepository.findByListId(listId);
        return userEntityList.stream().map(el -> modelMapper.map(el, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public Boolean insert(UserDto userDto) {
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        if (userEntity.getId() == null) {
            return userRepository.insert(userEntity);
        } else {
            return userRepository.updateById(userEntity);
        }
    }

    @Override
    public Boolean insertAll(List<UserDto> userDtoList) {
        List<UserEntity> userEntityList = userDtoList.stream().map(el -> modelMapper.map(el, UserEntity.class)).collect(Collectors.toList());
        return userRepository.insertAll(userEntityList);
    }


    @Override
    public Boolean updateById(UserDto userDto) {
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        return userRepository.updateById(userEntity);
    }

    @Override
    public Boolean deleteById(Long id) {
        return userRepository.deleteById(id);
    }

    @Override
    public UserDto findByLogin(String login) {
        UserEntity userEntity = userRepository.findByLogin(login);
        return modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login);
    }

}

