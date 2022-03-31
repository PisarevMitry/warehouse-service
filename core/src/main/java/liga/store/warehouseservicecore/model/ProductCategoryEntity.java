package liga.store.warehouseservicecore.model;

import lombok.Data;

@Data
public class ProductCategoryEntity {

    private Long id;
    private String title;
    private Long parentId;
}
