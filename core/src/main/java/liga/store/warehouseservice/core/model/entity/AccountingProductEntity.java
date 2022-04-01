package liga.store.warehouseservice.core.model.entity;

import lombok.Data;

@Data
public class AccountingProductEntity {
    private Long id;
    private Long productId;
    private Integer amount;
    private Integer price;
}
