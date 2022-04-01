package liga.store.warehouseservice.core.repository;

import java.util.List;

/**
 * Интерфейс опрядеяющий общие методы работы с БД
 * @param <E> Entity сущность
 */
public interface BasicMethodRepository<E> {

    /**
     * Метод для поиска всех записей
     * @return список объектов класса Entity
     */
    List<E> findAll();

    /**
     * Метод для поиска одной записи
     * @param id идентификатор записи
     * @return объект класса Entity
     */
    E findById(Long id);

    /**
     * Метод для поиска множества записи
     * @param listId список идентификаторов записей
     * @return список объектов класса Entity
     */
    List<E> findByListId(List<Long> listId);

    /**
     * Метод для добавления записи в таблицу
     * @param e объект класса Entity
     */
    void insert(E e);

    /**
     * Метод для добавления множества записей в таблицу
     * @param eList список объектов класса Entity
     */
    void insertAll(List<E> eList);

    /**
     * Метод для изменения записи в таблице
     * @param e обновленный объект класса Entity
     */
    void updateById(E e);

    /**
     * Метод для удаления записи
     * @param id идентификатор записи
     */
    void deleteById(Long id);
}
