package liga.store.warehouseservice.core.repository;

import liga.store.warehouseservice.core.model.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface UserRepository extends BasicMethodRepository<UserEntity> {

    @Override
    List<UserEntity> findAll();

    @Override
    UserEntity findById(@RequestParam("userId") Long userId);

    @Override
    List<UserEntity> findByListId(@RequestParam("userListId") List<Long> userListId);

    @Override
    Boolean insert(@RequestParam("userEntity") UserEntity userEntity);

    @Override
    Boolean insertAll(@RequestParam("UserEntityList") List<UserEntity> UserEntityList);

    @Override
    Boolean updateById(@RequestParam("userEntity") UserEntity userEntity);

    @Override
    Boolean deleteById(@RequestParam("userId") Long userId);

    UserEntity findByLogin(@RequestParam("login") String login);
}
