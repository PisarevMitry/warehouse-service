package liga.store.warehouseservice.core.repository;

import liga.store.warehouseservice.core.model.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductRepository extends BasicMethodRepository<ProductEntity> {
    @Override
    public List<ProductEntity> findAll();

    @Override
    public ProductEntity findById(Long productId);

    @Override
    public List<ProductEntity> findByListId(List<Long> productListId);

    @Override
    public void insert(ProductEntity productEntity);

    @Override
    public void insertAll(List<ProductEntity> productEntityList);

    @Override
    public void updateById(ProductEntity productEntity);

    @Override
    public void deleteById(Long productId);

    //List<ProductEntity> findByListOption(@RequestBody @Param("productEntityOption") JSONObject productEntityOption);

}
