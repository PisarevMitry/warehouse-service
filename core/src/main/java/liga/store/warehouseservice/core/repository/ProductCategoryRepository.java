package liga.store.warehouseservice.core.repository;

import liga.store.warehouseservice.core.model.entity.ProductCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface ProductCategoryRepository extends BasicMethodRepository<ProductCategoryEntity> {
    @Override
    List<ProductCategoryEntity> findAll();

    @Override
    ProductCategoryEntity findById(@Param("productCategoryId") Long productCategoryId);

    @Override
    List<ProductCategoryEntity> findByListId(@Param("productCategoryListId") List<Long> productCategoryListId);

    @Override
    void insert(@RequestBody @Param("productCategoryEntity") ProductCategoryEntity productCategoryEntity);

    @Override
    void insertAll(@RequestBody @Param("productCategoryEntityList") List<ProductCategoryEntity> productCategoryEntityList);

    @Override
    void updateById(@RequestBody @Param("productCategoryEntity") ProductCategoryEntity productCategoryEntity);

    @Override
    void deleteById(@Param("productCategoryId") Long productCategoryId);


   /* List<ProductCategoryEntity> findByParentId(@Param("productCategoryId") Long productCategoryId);

    Tree<ProductCategoryEntity> findTreeByParentId(@Param("productCategoryId") Long productCategoryId);*/
}