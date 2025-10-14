package Module_6.ComposerApp;

/**
 * DAO specialization for Composer entities.
 * Extends the generic DAO using Composer as the entity and Integer as the key.
 * Assignment 6.2
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public interface ComposerDao extends GenericDao<Composer, Integer> {
  // No extra members required by the spec; inherits findAll, findBy, insert.
}

