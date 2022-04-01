package liga.store.warehouseservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPhotoDto {
    private Long id;
    @NotBlank
    private String url;
    private Long parentId;
}
