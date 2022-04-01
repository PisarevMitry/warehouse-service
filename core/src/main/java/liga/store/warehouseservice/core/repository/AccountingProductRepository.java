package liga.store.warehouseservice.core.repository;

import liga.store.warehouseservice.core.model.entity.AccountingProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountingProductRepository extends BasicMethodRepository<AccountingProductEntity> {

    @Override
    List<AccountingProductEntity> findAll();

    @Override
    AccountingProductEntity findById(@Param("AccountingProductId") Long AccountingProductId);

    @Override
    List<AccountingProductEntity> findByListId(@Param("AccountingProductListId") List<Long> AccountingProductListId);

    @Override
    void insert(@Param("accountingProductEntity") AccountingProductEntity accountingProductEntity);

    @Override
    void insertAll(@Param("accountingProductEntityList") List<AccountingProductEntity> accountingProductEntityList);

    @Override
    void updateById(@Param("accountingProductEntity") AccountingProductEntity accountingProductEntity);

    @Override
    void deleteById(@Param("AccountingProductId") Long AccountingProductId);

    AccountingProductEntity findByProductId(@Param("productId") Long productId);
}
