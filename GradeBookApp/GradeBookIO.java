package GradeBookApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Assignment 11.2
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 * Utility class for reading from and writing to the grades.csv file.
 * <p>
 * CSV format (with header):
 * firstName,lastName,course,grade
 */
public class GradeBookIO {

  /** File name used to store grade entries. */
  public static final String FILE_NAME = "grades.csv";

  /**
   * Appends a student entry to grades.csv.
   * If the file does not exist, writes a header row first.
   *
   * @param student the student to append
   * @throws IOException if an I/O error occurs
   */
  public static void appendStudent(Student student) throws IOException {
    File file = new File(FILE_NAME);
    boolean fileExists = file.exists();

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
      // Write header if file is new
      if (!fileExists) {
        writer.write("firstName,lastName,course,grade");
        writer.newLine();
      }
      // Write CSV line
      String line = String.join(",",
          escape(student.getFirstName()),
          escape(student.getLastName()),
          escape(student.getCourse()),
          escape(student.getGrade())
      );
      writer.write(line);
      writer.newLine();
    }
  }

  /**
   * Reads the entire grades.csv file and returns its contents as a single string.
   * If the file does not exist, returns a friendly message.
   *
   * @return file contents or "No grades found." message
   * @throws IOException if an I/O error occurs
   */
  public static String readAllGrades() throws IOException {
    File file = new File(FILE_NAME);
    if (!file.exists()) {
      return "No grades found. The file \"" + FILE_NAME + "\" does not exist yet.";
    }

    StringBuilder sb = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        sb.append(line).append(System.lineSeparator());
      }
    }
    return sb.toString().trim();
  }

  /**
   * Escapes commas in values by wrapping them in quotes if needed.
   * Simple version for this assignment.
   *
   * @param value string to escape
   * @return escaped string
   */
  private static String escape(String value) {
    if (value == null) {
      return "";
    }
    if (value.contains(",") || value.contains("\"")) {
      value = value.replace("\"", "\"\"");
      return "\"" + value + "\"";
    }
    return value;
  }
}

