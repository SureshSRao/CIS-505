package Module_6.ComposerApp;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory implementation of the Composer DAO.
 * Seeds five composers by default.
 * Assignment 6.2
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public class MemComposerDao implements ComposerDao {

  /** Backing list that serves as the in-memory data store. */
  private List<Composer> composers;

  /** No-arg constructor: creates a default list of five composer objects. */
  public MemComposerDao() {
    composers = new ArrayList<>();
    // Seed data (ids are unique and easy to type during demos)
    composers.add(new Composer(1007, "Ludwig van Beethoven", "Classical"));
    composers.add(new Composer(1008, "Johann Sebastian Bach", "Classical"));
    composers.add(new Composer(1009, "Wolfgang Amadeus Mozart", "Classical"));
    composers.add(new Composer(1010, "Johannes Brahms", "Classical"));
    composers.add(new Composer(1011, "Joseph Haydn", "Classical"));
  }

  /** {@inheritDoc} */
  @Override
  public List<Composer> findAll() {
    return new ArrayList<>(composers); // return a copy to avoid external mutation
  }

  /** {@inheritDoc} */
  @Override
  public Composer findBy(Integer id) {
    if (id == null) return null;
    for (Composer c : composers) {
      if (c.getId() == id) return c;
    }
    return null;
  }

  /** {@inheritDoc} */
  @Override
  public void insert(Composer item) {
    if (item != null) {
      composers.add(item);
    }
  }
}

