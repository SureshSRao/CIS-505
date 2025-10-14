package Module_6.ComposerApp;

/**
 * Represents a music composer with an id, name, and genre.
 * Each field is printed on its own line by toString().
 * Assignment 6.2
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public class Composer {

  /** Unique identifier for the composer. */
  private int id;

  /** Full name of the composer. */
  private String name = "";

  /** Primary genre of the composer. */
  private String genre = "";

  /** No-argument constructor that creates a default composer. */
  public Composer() {
    // default values: id = 0, name = "", genre = ""
  }

  /**
   * Full-argument constructor.
   * @param id    unique id
   * @param name  composer's name
   * @param genre composer's genre
   */
  public Composer(int id, String name, String genre) {
    this.id = id;
    this.name = name;
    this.genre = genre;
  }

  /** @return the composer id */
  public int getId() { return id; }

  /** @return the composer name */
  public String getName() { return name; }

  /** @return the composer genre */
  public String getGenre() { return genre; }

  /**
   * Returns a three-line labeled description of this composer.
   * Each line is left-padded with two spaces to match screenshot indentation.
   */
  @Override
  public String toString() {
    return "  Id: " + id + "\n"
         + "  Name: " + name + "\n"
         + "  Genre: " + genre;
  }
}

