package liga.store.warehouseservice.core.repository;

import liga.store.warehouseservice.core.model.entity.ProductCategoryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface ProductCategoryRepository extends BasicMethodRepository<ProductCategoryEntity> {

    @Override
    List<ProductCategoryEntity> findAll();

    @Override
    ProductCategoryEntity findById(@RequestParam("productCategoryId") Long productCategoryId);

    @Override
    List<ProductCategoryEntity> findByListId(@RequestParam("productCategoryListId") List<Long> productCategoryListId);

    @Override
    Boolean insert(@RequestParam("productCategoryEntity") ProductCategoryEntity productCategoryEntity);

    @Override
    Boolean insertAll(@RequestParam("productCategoryEntityList") List<ProductCategoryEntity> productCategoryEntityList);

    @Override
    Boolean updateById(@RequestParam("productCategoryEntity") ProductCategoryEntity productCategoryEntity);

    @Override
    Boolean deleteById(@RequestParam("productCategoryId") Long productCategoryId);


   /* List<ProductCategoryEntity> findByParentId(@Param("productCategoryId") Long productCategoryId);

    Tree<ProductCategoryEntity> findTreeByParentId(@Param("productCategoryId") Long productCategoryId);*/
}