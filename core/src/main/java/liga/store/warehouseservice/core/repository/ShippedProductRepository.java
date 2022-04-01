package liga.store.warehouseservice.core.repository;

import liga.store.warehouseservice.core.model.entity.ShippedProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShippedProductRepository extends BasicMethodRepository<ShippedProductEntity> {

    @Override
    List<ShippedProductEntity> findAll();

    @Override
    ShippedProductEntity findById(@Param("shippedProductId") Long shippedProductId);

    @Override
    List<ShippedProductEntity> findByListId(@Param("shippedProductListId") List<Long> shippedProductListId);

    @Override
    void insert(@Param("shippedProductEntity") ShippedProductEntity shippedProductEntity);

    @Override
    void insertAll(@Param("shippedProductEntityList") List<ShippedProductEntity> shippedProductEntityList);

    @Override
    void updateById(@Param("shippedProductEntity") ShippedProductEntity shippedProductEntity);

    @Override
    void deleteById(@Param("shippedProductId") Long shippedProductId);
}
