package liga.store.warehouseservice.core.model.entity;

import lombok.Data;

@Data
public class ShippedProductEntity {
    Long id;
    Long productId;
    Integer amountDifference;
    String receiver;
    String sender;
    String carrier;
    String numberOfContract;
}
