package liga.store.warehouseservice.core.service.impl;

import liga.store.warehouseservice.core.model.entity.ShippedProductEntity;
import liga.store.warehouseservice.core.repository.ShippedProductRepository;
import liga.store.warehouseservice.core.service.ShippedProductService;
import liga.store.warehouseservice.dto.ShippedProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ShippedProductServiceImpl implements ShippedProductService {

    private final ShippedProductRepository shippedProductRepository;
    private final ModelMapper modelMapper;

    public ShippedProductServiceImpl(ShippedProductRepository shippedProductRepository, ModelMapper modelMapper) {
        this.shippedProductRepository = shippedProductRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ShippedProductDto> findAll() {
        List<ShippedProductEntity> shippedProductEntityList = shippedProductRepository.findAll();
        return shippedProductEntityList.stream().map(el -> modelMapper.map(el, ShippedProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public ShippedProductDto findById(Long id) {
        ShippedProductEntity shippedProductEntity = shippedProductRepository.findById(id);
        return modelMapper.map(shippedProductEntity, ShippedProductDto.class);
    }

    @Override
    public List<ShippedProductDto> findByListId(List<Long> listId) {
        List<ShippedProductEntity> shippedProductEntityList = shippedProductRepository.findByListId(listId);
        return shippedProductEntityList.stream().map(el -> modelMapper.map(el, ShippedProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public void insert(ShippedProductDto shippedProductDto) {
        ShippedProductEntity shippedProductEntity = modelMapper.map(shippedProductDto, ShippedProductEntity.class);
        if (shippedProductEntity.getId() == null) {
            shippedProductRepository.insert(shippedProductEntity);
        } else {
            shippedProductRepository.updateById(shippedProductEntity);
        }
    }

    @Override
    public void insertAll(List<ShippedProductDto> shippedProductDtoList) {
        List<ShippedProductEntity> shippedProductEntityList =
                shippedProductDtoList.stream().map(el -> modelMapper.map(el, ShippedProductEntity.class)).collect(Collectors.toList());
        shippedProductRepository.insertAll(shippedProductEntityList);
    }

    @Override
    public void updateById(ShippedProductDto shippedProductDto) {
        ShippedProductEntity shippedProductEntity = modelMapper.map(shippedProductDto, ShippedProductEntity.class);
        shippedProductRepository.updateById(shippedProductEntity);
    }

    @Override
    public void deleteById(Long id) {
        shippedProductRepository.deleteById(id);
    }
}
