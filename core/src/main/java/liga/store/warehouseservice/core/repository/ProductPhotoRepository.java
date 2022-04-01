package liga.store.warehouseservice.core.repository;

import liga.store.warehouseservice.core.model.entity.ProductPhotoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface ProductPhotoRepository extends BasicMethodRepository<ProductPhotoEntity> {

    @Override
    List<ProductPhotoEntity> findAll();

    @Override
    ProductPhotoEntity findById(@RequestParam("productPhotoId") Long productPhotoId);

    @Override
    List<ProductPhotoEntity> findByListId(@RequestParam("productPhotoListId") List<Long> productPhotoListId);

    @Override
    void insert(@RequestParam("productPhotoEntity") ProductPhotoEntity productPhotoEntity);

    @Override
    void insertAll(@RequestParam("productPhotoEntityList") List<ProductPhotoEntity> productPhotoEntityList);

    @Override
    void updateById(@RequestParam("productPhotoEntity") ProductPhotoEntity productPhotoEntity);

    @Override
    void deleteById(@RequestParam("productPhotoId") Long productPhotoId);

    //List<ProductPhotoEntity> findRecurById(@Param("productPhotoId") Long productPhotoId);
}
