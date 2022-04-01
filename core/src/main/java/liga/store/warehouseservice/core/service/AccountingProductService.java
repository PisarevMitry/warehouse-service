package liga.store.warehouseservice.core.service;

import liga.store.warehouseservice.dto.AccountingProductDto;

public interface AccountingProductService extends CrudService<AccountingProductDto> {
    AccountingProductDto findByProductId(Long productId);
}
