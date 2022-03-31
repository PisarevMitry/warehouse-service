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
    public void insert(ProductDto productDto) {
        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        if (productEntity.getId() == null) {
            productRepository.insert(productEntity);
        } else {
            productRepository.updateById(productEntity);
        }
    }

    @Override
    public void insertAll(List<ProductDto> productDtoList) {
        List<ProductEntity> productEntityList = productDtoList.stream().map(el -> modelMapper.map(el, ProductEntity.class)).collect(Collectors.toList());
        productRepository.insertAll(productEntityList);
    }

    @Override
    public void updateById(ProductDto productDto) {
        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        productRepository.updateById(productEntity);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
