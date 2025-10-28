package Module_8;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * SripathiRao Future Value App
 *
 * Assignment 8.2
 * 
 * @author Suresh Sripathi Rao
 * @version 1.0
 * <p>This JavaFX application meets the Assignment 8.2 requirements:
 * <ul>
 *   <li>Extends {@code Application} and overrides {@code start(Stage)}</li>
 *   <li>Declares two TextFields, one TextArea, five Labels, one ComboBox&lt;Integer&gt;, two Buttons</li>
 *   <li>Sets label/button text to match a typical "Future Value" UX (see notes below)</li>
 *   <li>Uses a GridPane aligned CENTER with padding (11.5, 12.5, 13.5, 14.5) and gaps H=5.5, V=5.5</li>
 *   <li>Adds a red, right-aligned format hint label for interest rate</li>
 *   <li>Adds Clear/Calculate buttons inside an HBox (spacing=10, padding=15,0,15,30)</li>
 *   <li>Sets window title to "Suresh Future Value App"</li>
 * </ul>
 *
 * <p><strong>Labels used (5):</strong>
 * <ol>
 *   <li>Monthly Payment:</li>
 *   <li>Interest Rate:</li>
 *   <li>(format hint) Enter rate as 11.1 for 11.1%</li>
 *   <li>Years:</li>
 * </ol>
 *
 * <p>Controls mapping required by the instructions:
 * <ul>
 *   <li>TextFields: monthly payment, interest rate</li>
 *   <li>TextArea: future value display</li>
 *   <li>ComboBox&lt;Integer&gt;: years (pre-populated)</li>
 *   <li>Buttons: Calculate, Clear</li>
 * </ul>
 *
 * <p>Behavior:
 * <ul>
 *   <li>Calculates the rate</li>
 *   
 * </ul>
 *
 * <p>All UI labels, spacing, and alignment follow the Assignment 8.2 layout constraints.
 */
public class SripathiRaoEnhancedFutureValueApp extends Application {

    // --- Required controls per instructions ---

    /** TextField for Monthly Payment input. */
    private TextField txtMonthlyPayment;

    /** TextField for Interest Rate (APR as XX.X). */
    private TextField txtInterestRate;

    /** TextArea to display the Future Value result. */
    private TextArea  txtAreaFutureValue;

    /** Label: "Monthly Payment:" */
    private Label lblMonthlyPayment;

    /** Label: "Interest Rate:" */
    private Label lblInterestRate;

    /** Label: red format hint for interest rate, right aligned. */
    private Label lblInterestRateFormat;

    /** Label: "Years:" */
    private Label lblYears;

    /** ComboBox&lt;Integer&gt; for Years selection. */
    private ComboBox<Integer> cboYears;

    /** Button: "Calculate" */
    private Button btnCalculate;

    /** Button: "Clear" */
    private Button btnClear;

    /** Label: "Future Value Date:" */
    private Label lblFutureValueDate;

    /**
     * Application entry point for JavaFX UI.
     * Builds the GridPane, wires event handlers, and shows the stage.
     *
     * @param primaryStage the primary stage provided by the JavaFX runtime
     */
    @Override
    public void start(Stage primaryStage) {

        // -- Build the GridPane (Exhibit B/C step c) --
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);

        // -- Instantiate controls and set default texts (Exhibit C/D) --
        lblMonthlyPayment     = new Label("Monthly Payment:");
        lblInterestRate       = new Label("Interest Rate:");
        lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
        lblYears              = new Label("Years:");
        lblFutureValueDate = new Label();

        txtMonthlyPayment = new TextField();
        txtMonthlyPayment.setPrefWidth(25);
        txtInterestRate   = new TextField();
        txtInterestRate.setPrefWidth(25);

        txtAreaFutureValue = new TextArea();
        txtAreaFutureValue.setEditable(false);
        txtAreaFutureValue.setPrefRowCount(4);
        txtAreaFutureValue.setPrefWidth(25);

        cboYears = new ComboBox<Integer>();
        // Years combo: include 0 as first item because the instructions say "set the cboYears value to 0"
        cboYears.getItems().add(0);
        IntStream.rangeClosed(1, 40).forEach(cboYears.getItems()::add); // 1..40 years
        cboYears.setValue(0);
        cboYears.setPrefWidth(150);

        btnCalculate = new Button("Calculate");
        btnClear     = new Button("Clear");
        

        // Add controls to GridPane, row by row
        // Row 0: Monthly Payment label + field
        grid.add(lblMonthlyPayment, 0, 0);
        grid.add(txtMonthlyPayment, 1, 0);

        // Row 1: Interest Rate label + field
        grid.add(lblInterestRate, 0, 1);
        grid.add(txtInterestRate, 1, 1);

        // Row 2: Interest rate format hint (red, right aligned)
        lblInterestRateFormat.setTextFill(Color.RED);
        grid.add(lblInterestRateFormat, 1, 2);
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);

        // Row 3: Years label + combo box
        grid.add(lblYears, 0, 3);
        grid.add(cboYears, 1, 3);        

        // Row 4: Buttons inside an HBox (spacing=10, padding=15,0,15,30)
        HBox actionBtnContainer = new HBox(10, btnClear, btnCalculate);
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        grid.add(actionBtnContainer, 1, 4);

        // Row 5: Label
        grid.add(lblFutureValueDate, 0, 5,2,1);

        // Row 6: text area
        grid.add(txtAreaFutureValue,0,6,2,1);

        // Wire events to private methods (per instructions)
        btnClear.setOnAction(e -> clearFormFields());
        btnCalculate.setOnAction(e -> calculateResults());

        // -- Stage title per instructions (f) --
        primaryStage.setTitle("Suresh Future Value App");

        // -- Show scene --
        primaryStage.setScene(new Scene(grid, 300, 300));
        primaryStage.show();
    }

    /**
   * Clears all form inputs and output fields.
   * Sets txtMonthlyPayment, txtInterestRate, txtResults, lblFutureValueDate to empty.
   * Sets cbYears to 0.
   */
  private void clearFormFields() {
    txtMonthlyPayment.setText("");
    txtInterestRate.setText("");
    txtAreaFutureValue.setText("");
    lblFutureValueDate.setText("");
    cboYears.setValue(0);
  }

  /**
   * Collects user inputs, calls FinanceCalculator.calculateFutureValue, and
   * displays the date and formatted result.
   * lblFutureValueDate: "Calculation as of <today's date>"
   * txtResults: "The future value is <futureValue>"
   */
  private void calculateResults() {
    try {
      double monthlyPayment = Double.parseDouble(txtMonthlyPayment.getText().trim());
      double rate = Double.parseDouble(txtInterestRate.getText().trim());
      Integer years = cboYears.getValue() == null ? 0 : cboYears.getValue();

      double fv = FinanceCalculator.calculateFutureValue(monthlyPayment, rate, years);

      lblFutureValueDate.setText("Calculation as of " + getToday());
      txtAreaFutureValue.setText(String.format("The future value is $%,.2f", fv));
    } catch (NumberFormatException ex) {
      lblFutureValueDate.setText("");
      txtAreaFutureValue.setText("Please enter valid numeric values for payment and rate, and select years.");
    }
  }

  /**
   * Returns today's date in "MM/dd/yyyy" format.
   * @return formatted date string
   */
  private String getToday() {
    return new SimpleDateFormat("MM/dd/yyyy").format(new Date());
  }


    /**
     * Standard Java main to launch the JavaFX application.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        launch(args);
    }
}

