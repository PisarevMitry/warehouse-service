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
    void insert(@RequestParam("shippedProductEntity") ShippedProductEntity shippedProductEntity);

    @Override
    void insertAll(@RequestParam("shippedProductEntityList") List<ShippedProductEntity> shippedProductEntityList);

    @Override
    void updateById(@RequestParam("shippedProductEntity") ShippedProductEntity shippedProductEntity);

    @Override
    void deleteById(@RequestParam("shippedProductId") Long shippedProductId);
}
