package liga.store.warehouseservice.core.model.entity;

import lombok.Data;

@Data
public class ProductCategoryEntity {

    private Long id;
    private String title;
    private Long parentId;
}
