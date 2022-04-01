package liga.store.warehouseservice.core.repository;

import liga.store.warehouseservice.core.model.entity.AccountingProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface AccountingProductRepository extends BasicMethodRepository<AccountingProductEntity> {

    @Override
    List<AccountingProductEntity> findAll();

    @Override
    AccountingProductEntity findById(@RequestParam("accountingProductId") Long accountingProductId);

    @Override
    List<AccountingProductEntity> findByListId(@RequestParam("accountingProductListId") List<Long> accountingProductListId);

    @Override
    void insert(@RequestParam("accountingProductEntity") AccountingProductEntity accountingProductEntity);

    @Override
    void insertAll(@RequestParam("accountingProductEntityList") List<AccountingProductEntity> accountingProductEntityList);

    @Override
    void updateById(@RequestParam("accountingProductEntity") AccountingProductEntity accountingProductEntity);

    @Override
    void deleteById(@RequestParam("accountingProductId") Long accountingProductId);

    AccountingProductEntity findByProductId(@RequestParam("productId") Long productId);
}
