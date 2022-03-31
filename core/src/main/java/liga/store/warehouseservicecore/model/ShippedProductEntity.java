package liga.store.warehouseservicecore.model;

import lombok.Data;

@Data
public class ShippedProductEntity {
    Long id;
    Long productId;
    Integer amountDifference;
    String receiver;
    String sender;
    String carrier;
    String number_of_contract;
}
