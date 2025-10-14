package Module_6.ComposerApp;

import java.util.List;

/**
 * Generic DAO interface describing common data access operations.
 *
 * Assignment 6.2
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 * @param <T> entity type
 * @param <K> key type (e.g., Integer)
 */
public interface GenericDao<T, K> {
  /**
   * Finds and returns all entities.
   * @return list of entities
   */
  List<T> findAll();

  /**
   * Finds an entity by its key (id).
   * @param id key value
   * @return the entity if found; otherwise null
   */
  T findBy(K id);

  /**
   * Inserts a new entity into the data store.
   * @param item the entity to insert
   */
  void insert(T item);
}

