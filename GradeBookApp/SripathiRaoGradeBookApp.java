package GradeBookApp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Assignment 10.2 / 11.2
 * 
 * @author Suresh Sripathi Rao
 * @version 2.0
 * Grade Book - UI Only (Module: Capstone Project UI)
 * <p>
 * This JavaFX application builds the user interface specified in the assignment:
 * <ul>
 *   <li>Labeled fields: First Name, Last Name, Course, and Grade (ComboBox A-F)</li>
 *   <li>Buttons: Save Entry, View Grades, Clear Form</li>
 *   <li>Results area to display entries later</li>
 *   <li>File naming: grades.csv (to be implemented next module)</li>
 * </ul>
 * Event handling and CSV persistence are intentionally deferred to the next module,
 * as directed in the assignment brief.
 */
public class SripathiRaoGradeBookApp extends Application {

  // --- Form controls ---
  private TextField txtFirstName;
  private TextField txtLastName;
  private TextField txtCourse;
  private ComboBox<String> cboGrade;

  // --- Results display (read-only) ---
  private TextArea txtResults;

  // --- Action buttons ---
  private Button btnSaveEntry;   // to be wired next module
  private Button btnViewGrades;  // to be wired next module
  private Button btnClearForm;   // to be wired next module

  @Override
  public void start(Stage stage) {
    // Title label
    Label lblTitle = new Label("Grade Book");
    lblTitle.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

    // Grid for labeled inputs
    GridPane form = new GridPane();
    form.setAlignment(Pos.CENTER_LEFT);
    form.setHgap(10);
    form.setVgap(10);
    form.setPadding(new Insets(12, 12, 12, 12));

    Label lblFirstName = new Label("First Name:");
    Label lblLastName  = new Label("Last Name:");
    Label lblCourse    = new Label("Course:");
    Label lblGrade     = new Label("Grade:");

    txtFirstName = new TextField();
    txtLastName  = new TextField();
    txtCourse    = new TextField();

    cboGrade = new ComboBox<>();
    cboGrade.getItems().addAll("A", "B", "C", "D", "F");
    cboGrade.getSelectionModel().selectFirst();

    // Place controls in grid
    form.add(lblFirstName, 0, 0);
    form.add(txtFirstName, 1, 0);
    form.add(lblLastName,  0, 1);
    form.add(txtLastName,  1, 1);
    form.add(lblCourse,    0, 2);
    form.add(txtCourse,    1, 2);
    form.add(lblGrade,     0, 3);
    form.add(cboGrade,     1, 3);

    // Buttons row (UI only for this module; handlers to be added next)
    btnSaveEntry  = new Button("Save");
    btnViewGrades = new Button("View Grades");
    btnClearForm  = new Button("Clear");

    HBox buttonRow = new HBox(10, btnClearForm, btnViewGrades, btnSaveEntry);

    buttonRow.setAlignment(Pos.CENTER_LEFT);
    buttonRow.setPadding(new Insets(6, 0, 6, 0));

    // Results area
    Label lblResults = new Label("Results:");
    txtResults = new TextArea();
    txtResults.setEditable(false);
    txtResults.setPrefRowCount(10);
    txtResults.setWrapText(true);
    VBox.setVgrow(txtResults, Priority.ALWAYS);

    // Layout root
    VBox root = new VBox(10,
        lblTitle,
        new Separator(),
        form,
        buttonRow,
        lblResults,
        txtResults
    );
    root.setPadding(new Insets(14, 14, 14, 14));

    // --- EVENT HANDLERS ---

    // Save Entry: validate, append to CSV, show confirmation
    btnSaveEntry.setOnAction(e -> handleSaveEntry());

    // View Grades: read CSV and show contents
    btnViewGrades.setOnAction(e -> handleViewGrades());

    // Clear Form: reset inputs and results
    btnClearForm.setOnAction(e -> handleClearForm());

    stage.setTitle("SripathiRaoGradeBookApp");
    stage.setScene(new Scene(root, 520, 480));
    stage.show();
  }

  /**
   * Handles the Save Entry button click.
   * Validates inputs, appends a Student entry to grades.csv, and shows feedback.
   */
  private void handleSaveEntry() {
    txtResults.clear();

    String firstName = txtFirstName.getText().trim();
    String lastName  = txtLastName.getText().trim();
    String course    = txtCourse.getText().trim();
    String grade     = cboGrade.getValue();

    // Basic validation
    if (firstName.isEmpty() || lastName.isEmpty() || course.isEmpty()) {
      txtResults.setText("Please fill in First Name, Last Name, and Course before saving.");
      return;
    }

    Student s = new Student(firstName, lastName, course, grade);

    try {
      GradeBookIO.appendStudent(s);
      txtResults.setText("Entry saved to " + GradeBookIO.FILE_NAME + ":\n\n" + s.toString());
      // Optionally clear the fields after save (comment out if not desired)
      // handleClearForm();
    } catch (Exception ex) {
      txtResults.setText("Error saving entry: " + ex.getMessage());
    }
  }

  /**
   * Handles the View Grades button click.
   * Reads all entries from grades.csv and displays them in the Results area.
   */
  private void handleViewGrades() {
    txtResults.clear();
    try {
      String contents = GradeBookIO.readAllGrades();
      txtResults.setText(contents);
    } catch (Exception ex) {
      txtResults.setText("Error reading grades: " + ex.getMessage());
    }
  }

  /**
   * Handles the Clear Form button click.
   * Clears all input controls and the Results text area.
   */
  private void handleClearForm() {
    txtFirstName.clear();
    txtLastName.clear();
    txtCourse.clear();
    cboGrade.getSelectionModel().selectFirst();
    txtResults.clear();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

