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
    Boolean insert(@RequestParam("productPhotoEntity") ProductPhotoEntity productPhotoEntity);

    @Override
    Boolean insertAll(@RequestParam("productPhotoEntityList") List<ProductPhotoEntity> productPhotoEntityList);

    @Override
    Boolean updateById(@RequestParam("productPhotoEntity") ProductPhotoEntity productPhotoEntity);

    @Override
    Boolean deleteById(@RequestParam("productPhotoId") Long productPhotoId);

    //List<ProductPhotoEntity> findRecurById(@Param("productPhotoId") Long productPhotoId);
}
