package GradeBookApp;

/**
 * Assignment 10.2
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 * Represents a single grade book entry.
 * Holds student first name, last name, course, and letter grade (A-F).
 */
public class Student {

  /** First name of the student. */
  private String firstName;

  /** Last name of the student. */
  private String lastName;

  /** Course name associated with the grade. */
  private String course;

  /** Letter grade (A-F). */
  private String grade;

  /** No-argument constructor (default). */
  public Student() {
    this("", "", "", "");
  }

  /**
   * Full-argument constructor to initialize all fields.
   * @param firstName student's first name
   * @param lastName  student's last name
   * @param course    course name
   * @param grade     letter grade (A-F)
   */
  public Student(String firstName, String lastName, String course, String grade) {
    this.firstName = firstName;
    this.lastName  = lastName;
    this.course    = course;
    this.grade     = grade;
  }

  /** @return first name */
  public String getFirstName() { return firstName; }

  /** @param firstName set first name */
  public void setFirstName(String firstName) { this.firstName = firstName; }

  /** @return last name */
  public String getLastName() { return lastName; }

  /** @param lastName set last name */
  public void setLastName(String lastName) { this.lastName = lastName; }

  /** @return course */
  public String getCourse() { return course; }

  /** @param course set course */
  public void setCourse(String course) { this.course = course; }

  /** @return grade (A-F) */
  public String getGrade() { return grade; }

  /** @param grade set grade (A-F) */
  public void setGrade(String grade) { this.grade = grade; }

  /**
   * Returns a readable, labeled representation for the Results section.
   * (This will be useful when you later display entries in the UI.)
   */
  @Override
  public String toString() {
    return "First Name: " + firstName + "\n"
         + "Last Name: "  + lastName  + "\n"
         + "Course: "     + course    + "\n"
         + "Grade: "      + grade;
  }
}

