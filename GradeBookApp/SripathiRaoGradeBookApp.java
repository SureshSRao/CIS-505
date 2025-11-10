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
 * Assignment 10.2
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
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

    // NOTE: Event handling is intentionally not implemented in this module.
    // You will:
    // - On "Save Entry": validate inputs, construct Student, append to grades.csv (with header when new),
    //   and show Student.toString() in Results.
    // - On "View Grades": read grades.csv and display contents in Results.
    // - On "Clear Form": clear all inputs and Results.
    // Those steps are specified for next module—this submission is UI-only per instructions.

    stage.setTitle("SripathiRaoGradeBookApp");
    stage.setScene(new Scene(root, 520, 480));
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}

