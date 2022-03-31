package liga.store.warehouseservice.core.service;

import java.util.List;

public interface CrudService<D> {
    List<D> findAll();

    D findById(Long id);

    List<D> findByListId(List<Long> listId);

    void insert(D d);

    void insertAll(List<D> dList);

    void updateById(D d);

    void deleteById(Long id);
}
