package liga.store.warehouseservice.core.repository;

import liga.store.warehouseservice.core.model.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface ProductRepository extends BasicMethodRepository<ProductEntity> {

    @Override
    List<ProductEntity> findAll();

    @Override
    ProductEntity findById(@RequestParam("productId") Long productId);

    @Override
    List<ProductEntity> findByListId(@RequestParam("productListId") List<Long> productListId);

    @Override
    Boolean insert(@RequestParam("productEntity") ProductEntity productEntity);

    @Override
    Boolean insertAll(@RequestParam("productEntityList") List<ProductEntity> productEntityList);

    @Override
    Boolean updateById(@RequestParam("productEntity") ProductEntity productEntity);

    @Override
    Boolean deleteById(@RequestParam("productId") Long productId);

    //List<ProductEntity> findByListOption(@RequestBody @Param("productEntityOption") JSONObject productEntityOption);

}
