package liga.store.warehouseservice.core.repository;

import liga.store.warehouseservice.core.model.entity.LogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface LogRepository extends BasicMethodRepository<LogEntity> {

    @Override
    List<LogEntity> findAll();

    @Override
    LogEntity findById(@RequestParam("logId") Long logId);

    @Override
    Boolean insert(@RequestParam("logEntity") LogEntity logEntity);
}

