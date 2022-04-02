package liga.store.warehouseservice.core.service.impl;

import liga.store.warehouseservice.core.model.entity.ProductCategoryEntity;
import liga.store.warehouseservice.core.repository.ProductCategoryRepository;
import liga.store.warehouseservice.core.service.ProductCategoryService;
import liga.store.warehouseservice.dto.ProductCategoryDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ModelMapper modelMapper;

    public ProductCategoryServiceImpl(ProductCategoryRepository productCategoryRepository, ModelMapper modelMapper) {
        this.productCategoryRepository = productCategoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductCategoryDto> findAll() {
        List<ProductCategoryEntity> productCategoryEntityList = productCategoryRepository.findAll();
        return productCategoryEntityList.stream().map(el -> modelMapper.map(el, ProductCategoryDto.class)).collect(Collectors.toList());
    }

    @Override
    public ProductCategoryDto findById(Long id) {
        ProductCategoryEntity productCategoryEntity = productCategoryRepository.findById(id);
        return modelMapper.map(productCategoryEntity, ProductCategoryDto.class);
    }

    @Override
    public List<ProductCategoryDto> findByListId(List<Long> listId) {
        List<ProductCategoryEntity> productCategoryEntityList = productCategoryRepository.findByListId(listId);
        return productCategoryEntityList.stream().map(el -> modelMapper.map(el, ProductCategoryDto.class)).collect(Collectors.toList());
    }

    @Override
    public Boolean insert(ProductCategoryDto productCategoryDto) {
        ProductCategoryEntity productCategoryEntity = modelMapper.map(productCategoryDto, ProductCategoryEntity.class);
        if (productCategoryEntity.getId() == null) {
            return productCategoryRepository.insert(productCategoryEntity);
        } else {
            return productCategoryRepository.updateById(productCategoryEntity);
        }
    }

    @Override
    public Boolean insertAll(List<ProductCategoryDto> productCategoryDtoList) {
        List<ProductCategoryEntity> productCategoryEntityList =
                productCategoryDtoList.stream().map(el -> modelMapper.map(el, ProductCategoryEntity.class)).collect(Collectors.toList());
        return productCategoryRepository.insertAll(productCategoryEntityList);
    }


    @Override
    public Boolean updateById(ProductCategoryDto productCategoryDto) {
        ProductCategoryEntity productCategoryEntity = modelMapper.map(productCategoryDto, ProductCategoryEntity.class);
        return productCategoryRepository.updateById(productCategoryEntity);
    }

    @Override
    public Boolean deleteById(Long id) {
        return productCategoryRepository.deleteById(id);
    }
}
