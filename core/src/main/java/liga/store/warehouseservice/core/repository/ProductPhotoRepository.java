package liga.store.warehouseservice.core.repository;

import liga.store.warehouseservice.core.model.entity.ProductPhotoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ProductPhotoRepository extends BasicMethodRepository<ProductPhotoEntity> {
    @Override
    List<ProductPhotoEntity> findAll();

    @Override
    ProductPhotoEntity findById(@Param("productPhotoId") Long productPhotoId);

    @Override
    List<ProductPhotoEntity> findByListId(@Param("productPhotoListId") List<Long> productPhotoListId);

    @Override
    void insert(@RequestBody @Param("productPhotoEntity") ProductPhotoEntity productPhotoEntity);

    @Override
    void insertAll(@RequestBody @Param("productPhotoEntityList") List<ProductPhotoEntity> productPhotoEntityList);

    @Override
    void updateById(@RequestBody @Param("productPhotoEntity") ProductPhotoEntity productPhotoEntity);

    @Override
    void deleteById(@Param("productPhotoId") Long productPhotoId);

    //List<ProductPhotoEntity> findRecurById(@Param("productPhotoId") Long productPhotoId);
}
