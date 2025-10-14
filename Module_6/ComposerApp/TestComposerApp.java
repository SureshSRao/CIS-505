package Module_6.ComposerApp;

import java.util.List;
import java.util.Scanner;

/**
 * Console driver for the Composer application.
 * Shows a menu, lists composers, finds by id, and adds new composers.
 * All output uses two-space indentation to match screenshots.
 * Assignment 6.2
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 */
public class TestComposerApp {

  /**
   * Prints the main menu with two-space indentation.
   */
  public static void displayMenu() {
    System.out.println("  MENU OPTIONS");
    System.out.println("    1 - View Composers");
    System.out.println("    2 - Find Composer");
    System.out.println("    3 - Add Composer");
    System.out.println("    4 - Exit");
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ComposerDao dao = new MemComposerDao();

    System.out.println("  Welcome to the Composer App\n");

    String choice;
    do {
      displayMenu();
      System.out.print("  Please choose an option: ");
      choice = sc.nextLine().trim();
      System.out.println();
      switch (choice) {
        case "1": // View all
          List<Composer> list = dao.findAll();
          if (list.isEmpty()) {
            System.out.println("  No composers found.");
          } else {
            System.out.println("  --DISPLAYING COMPOSERS-- ");
            for (Composer c : list) {
              System.out.println(c.toString());
              System.out.println(); // blank line between entries
            }
          }
          break;

        case "2": // Find by id
          System.out.print("  Enter an id: ");
          String idText = sc.nextLine().trim();
          int id = 0;
          try {
            id = Integer.parseInt(idText);
          } catch (NumberFormatException ex) {
            System.out.println("  Error: Invalid id.");
            System.out.println();
            break;
          }
          Composer found = dao.findBy(id);
          if (found == null) {
            System.out.println("  Composer not found.");
          } else {
            System.out.println();
            System.out.println("  --DISPLAYING COMPOSERS-- ");
            System.out.println(found.toString());
          }
          System.out.println();
          break;

        case "3": // Add new
          System.out.print("  Enter an id: ");
          String nid = sc.nextLine().trim();
          int newId;
          try {
            newId = Integer.parseInt(nid);
          } catch (NumberFormatException ex) {
            System.out.println("  Error: Invalid id.");
            System.out.println();
            break;
          }

          System.out.print("  Enter a name: ");
          String name = sc.nextLine();

          System.out.print("  Enter a genre: ");
          String genre = sc.nextLine();

          dao.insert(new Composer(newId, name, genre));
          System.out.println();
          break;

        case "4":
          System.out.println("  Exiting program...");
          sc.close();
          return;

        default:
          System.out.println("  Error: Invalid Option.");
          System.out.println();
      }

    } while (true);
  }
}

