package liga.store.warehouseservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountingProductDto {
    private Long id;
    @NotNull
    private Long productId;
    private Integer amount;
    private Integer price;
}
