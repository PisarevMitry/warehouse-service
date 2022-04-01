package liga.store.warehouseservice.core.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogEntity {

    private Long id;

    private LocalDateTime createDttm;

    private String methodName;

    private String className;

    private String userName;
}