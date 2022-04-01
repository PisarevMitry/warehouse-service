package liga.store.warehouseservice.core.service.impl;

import liga.store.warehouseservice.core.model.entity.AccountingProductEntity;
import liga.store.warehouseservice.core.repository.AccountingProductRepository;
import liga.store.warehouseservice.core.service.AccountingProductService;
import liga.store.warehouseservice.dto.AccountingProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountingProductServiceImpl implements AccountingProductService {

    private final AccountingProductRepository accountingProductRepository;
    private final ModelMapper modelMapper;

    public AccountingProductServiceImpl(AccountingProductRepository accountingProductRepository, ModelMapper modelMapper) {
        this.accountingProductRepository = accountingProductRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<AccountingProductDto> findAll() {
        List<AccountingProductEntity> accountingProductEntityList = accountingProductRepository.findAll();
        return accountingProductEntityList.stream().map(el -> modelMapper.map(el, AccountingProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public AccountingProductDto findById(Long id) {
        AccountingProductEntity accountingProductEntity = accountingProductRepository.findById(id);
        return modelMapper.map(accountingProductEntity, AccountingProductDto.class);
    }

    @Override
    public List<AccountingProductDto> findByListId(List<Long> listId) {
        List<AccountingProductEntity> accountingProductEntity = accountingProductRepository.findByListId(listId);
        return accountingProductEntity.stream().map(el -> modelMapper.map(el, AccountingProductDto.class)).collect(Collectors.toList());
    }

    @Override
    public void insert(AccountingProductDto accountingProductDto) {
        AccountingProductEntity accountingProductEntity = modelMapper.map(accountingProductDto, AccountingProductEntity.class);
        if (accountingProductEntity.getId() == null) {
            accountingProductRepository.insert(accountingProductEntity);
        } else {
            accountingProductRepository.updateById(accountingProductEntity);
        }
    }

    @Override
    public void insertAll(List<AccountingProductDto> accountingProductDtoList) {
        List<AccountingProductEntity> accountingProductEntityList =
                accountingProductDtoList.stream().map(el -> modelMapper.map(el, AccountingProductEntity.class)).collect(Collectors.toList());
        accountingProductRepository.insertAll(accountingProductEntityList);
    }

    @Override
    public void updateById(AccountingProductDto accountingProductDto) {
        AccountingProductEntity accountingProductEntity = modelMapper.map(accountingProductDto, AccountingProductEntity.class);
        accountingProductRepository.updateById(accountingProductEntity);
    }

    @Override
    public void deleteById(Long id) {
        accountingProductRepository.deleteById(id);
    }

    @Override
    public AccountingProductDto findByProductId(Long productId) {
        AccountingProductEntity accountingProductEntity = accountingProductRepository.findByProductId(productId);
        return modelMapper.map(accountingProductEntity, AccountingProductDto.class);
    }
}
