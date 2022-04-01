package liga.store.warehouseservice.core.model.entity;

import lombok.Data;

@Data
public class ProductPhotoEntity {

    private Long id;
    private String url;
    private Long parentId;
}
