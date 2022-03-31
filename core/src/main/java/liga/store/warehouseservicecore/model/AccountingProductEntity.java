package liga.store.warehouseservicecore.model;

import lombok.Data;

@Data
public class AccountingProductEntity {
    private Long id;
    private Long productId;
    private Integer amount;
    private Integer price;
}
