package liga.store.warehouseservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDto {
    private Long id;
    @NotNull
    private String title;
    private Long parentId;
}
