package liga.store.warehouseservice.core.service;

import java.util.List;

public interface CrudService<D> {
    List<D> findAll();

    D findById(Long id);

    List<D> findByListId(List<Long> listId);

    Boolean insert(D d);

    Boolean insertAll(List<D> dList);

    Boolean updateById(D d);

    Boolean deleteById(Long id);
}
