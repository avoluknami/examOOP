package org.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private ChoiceBox<String> vehicleTypeChoiceBox;
    @FXML
    private TextField engineCapacityField;
    @FXML
    private TextField manufactureYearField;
    @FXML
    private Label resultLabel;

    @FXML
    public void calculateTax() {
        try {
            String selectedType = vehicleTypeChoiceBox.getValue();
            int engineCapacity = Integer.parseInt(engineCapacityField.getText());
            int manufactureYear = Integer.parseInt(manufactureYearField.getText());

            Vehicle vehicle = null;
            if ("CAR".equals(selectedType)) {
                vehicle = new Car(engineCapacity, manufactureYear);
            } else if ("BUS".equals(selectedType)) {
                vehicle = new Bus(engineCapacity, manufactureYear);
            } else if ("TRUCK".equals(selectedType)) {
                vehicle = new Truck(engineCapacity, manufactureYear);
            }

            if (vehicle != null) {
                double tax = vehicle.calculateTax();
                resultLabel.setText(String.format("Calculated Tax: %.2f", tax));
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers.");
        }
    }
}