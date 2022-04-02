package liga.store.warehouseservice.core.service.impl;

import liga.store.warehouseservice.core.model.entity.ProductPhotoEntity;
import liga.store.warehouseservice.core.repository.ProductPhotoRepository;
import liga.store.warehouseservice.core.service.ProductPhotoService;
import liga.store.warehouseservice.dto.ProductPhotoDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductPhotoServiceImpl implements ProductPhotoService {

    private final ProductPhotoRepository productPhotoRepository;
    private final ModelMapper modelMapper;

    public ProductPhotoServiceImpl(ProductPhotoRepository productPhotoRepository, ModelMapper modelMapper) {
        this.productPhotoRepository = productPhotoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductPhotoDto> findAll() {
        List<ProductPhotoEntity> productPhotoEntityList = productPhotoRepository.findAll();
        return productPhotoEntityList.stream().map(el -> modelMapper.map(el, ProductPhotoDto.class)).collect(Collectors.toList());
    }

    @Override
    public ProductPhotoDto findById(Long id) {
        ProductPhotoEntity productPhotoEntity = productPhotoRepository.findById(id);
        return modelMapper.map(productPhotoEntity, ProductPhotoDto.class);
    }

    @Override
    public List<ProductPhotoDto> findByListId(List<Long> listId) {
        List<ProductPhotoEntity> productPhotoEntityList = productPhotoRepository.findByListId(listId);
        return productPhotoEntityList.stream().map(el -> modelMapper.map(el, ProductPhotoDto.class)).collect(Collectors.toList());
    }

    @Override
    public Boolean insert(ProductPhotoDto productPhotoDto) {
        ProductPhotoEntity productPhotoEntity = modelMapper.map(productPhotoDto, ProductPhotoEntity.class);
        if (productPhotoEntity.getId() == null) {
            return productPhotoRepository.insert(productPhotoEntity);
        } else {
            return productPhotoRepository.updateById(productPhotoEntity);
        }
    }

    @Override
    public Boolean insertAll(List<ProductPhotoDto> productPhotoDtoList) {
        List<ProductPhotoEntity> productPhotoEntityList = productPhotoDtoList.stream().map(el -> modelMapper.map(el, ProductPhotoEntity.class)).collect(Collectors.toList());
        return productPhotoRepository.insertAll(productPhotoEntityList);
    }

    @Override
    public Boolean updateById(ProductPhotoDto productPhotoDto) {
        ProductPhotoEntity productPhotoEntity = modelMapper.map(productPhotoDto, ProductPhotoEntity.class);
        return productPhotoRepository.updateById(productPhotoEntity);
    }

    @Override
    public Boolean deleteById(Long id) {
        return productPhotoRepository.deleteById(id);
    }
}
