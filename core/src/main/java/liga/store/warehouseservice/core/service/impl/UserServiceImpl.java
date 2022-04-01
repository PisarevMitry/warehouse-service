package liga.store.warehouseservice.core.service.impl;


/*

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder =  new BCryptPasswordEncoder(12);;
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
    public void insert(UserDto userDto) {
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        if (userEntity.getId() == null) {
            userRepository.insert(userEntity);
        } else {
            userRepository.updateById(userEntity);
        }
    }

    @Override
    public void insertAll(List<UserDto> userDtoList) {
        List<UserEntity> userEntityList = userDtoList.stream().map(el -> modelMapper.map(el, UserEntity.class)).collect(Collectors.toList());
        userRepository.insertAll(userEntityList);
    }


    @Override
    public void updateById(UserDto userDto) {
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        userRepository.updateById(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public UserEntity findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return findByLogin(login);
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
*/

