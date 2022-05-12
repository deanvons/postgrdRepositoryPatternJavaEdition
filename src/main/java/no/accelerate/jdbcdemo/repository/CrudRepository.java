package no.accelerate.jdbcdemo.repository;

import java.util.List;

/**
 * Base Repository abstraction to encapsulate all
 * operations that can be performed on any object in the database.
 * @param <T> The object the repository is for
 * @param <ID> The identifier of the object
 */
public interface CrudRepository<T,ID> {
    List<T> findAll();
    T findById(ID id);
    int insert(T object);
    int update(T object);
    int delete(T object);
    int deleteById(ID id);
}
