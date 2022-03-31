package liga.store.warehouseservicecore.model;

import lombok.Data;

@Data
public class ProductPhotoEntity {

    private Long id;
    private String url;
    private Long parentId;
}
