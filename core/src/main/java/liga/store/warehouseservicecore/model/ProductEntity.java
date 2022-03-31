package liga.store.warehouseservicecore.model;

import lombok.Data;
import org.json.JSONObject;

@Data
public class ProductEntity {

    private Long id;
    private String title;
    private String description;
    private Long photoId;
    private JSONObject option;
    private Long categoryId;
}
