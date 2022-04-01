package liga.store.warehouseservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippedProductDto {
    Long id;
    @NotNull
    Long productId;
    @NotNull
    Integer amountDifference;
    @NotBlank
    String receiver;
    @NotBlank
    String sender;
    String carrier;
    String number_of_contract;
}
