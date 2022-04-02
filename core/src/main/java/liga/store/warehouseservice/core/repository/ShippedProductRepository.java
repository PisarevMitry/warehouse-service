package liga.store.warehouseservice.core.repository;

import liga.store.warehouseservice.core.model.entity.ShippedProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface ShippedProductRepository extends BasicMethodRepository<ShippedProductEntity> {

    @Override
    List<ShippedProductEntity> findAll();

    @Override
    ShippedProductEntity findById(@RequestParam("shippedProductId") Long shippedProductId);

    @Override
    List<ShippedProductEntity> findByListId(@RequestParam("shippedProductListId") List<Long> shippedProductListId);

    @Override
    Boolean insert(@RequestParam("shippedProductEntity") ShippedProductEntity shippedProductEntity);

    @Override
    Boolean insertAll(@RequestParam("shippedProductEntityList") List<ShippedProductEntity> shippedProductEntityList);

    @Override
    Boolean updateById(@RequestParam("shippedProductEntity") ShippedProductEntity shippedProductEntity);

    @Override
    Boolean deleteById(@RequestParam("shippedProductId") Long shippedProductId);
}
