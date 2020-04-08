package dao;

import java.util.List;

public interface CrudDAO<T, ID> {
    T getByID(ID id);

    void save(T obj);

    void update(T obj);

    void delete(T obj);

    List<T> getAll();
}
