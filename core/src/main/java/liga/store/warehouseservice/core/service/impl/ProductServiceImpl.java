package liga.store.warehouseservice.core.service.impl;

import liga.store.warehouseservice.core.model.entity.ProductEntity;
import liga.store.warehouseservice.core.repository.ProductRepository;
import liga.store.warehouseservice.core.service.ProductService;
import liga.store.warehouseservice.dto.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDto> findAll() {
        List<ProductEntity> productEntityList = productRepository.findAll();
        return productEntityList.stream().map(el -> modelMapper.map(el, ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(Long id) {
        ProductEntity productEntity = productRepository.findById(id);
        return modelMapper.map(productEntity, ProductDto.class);
    }

    @Override
    public List<ProductDto> findByListId(List<Long> listId) {
        List<ProductEntity> productEntityList = productRepository.findByListId(listId);
        return productEntityList.stream().map(el -> modelMapper.map(el, ProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public Boolean insert(ProductDto productDto) {
        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        if (productEntity.getId() == null) {
            return productRepository.insert(productEntity);
        } else {
            return false;
        }
    }

    @Override
    public Boolean insertAll(List<ProductDto> productDtoList) {
        List<ProductEntity> productEntityList = productDtoList.stream().map(el -> modelMapper.map(el, ProductEntity.class)).collect(Collectors.toList());
        return productRepository.insertAll(productEntityList);
    }

    @Override
    public Boolean updateById(ProductDto productDto) {
        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        return productRepository.updateById(productEntity);
    }

    @Override
    public Boolean deleteById(Long id) {
        return productRepository.deleteById(id);
    }
}
