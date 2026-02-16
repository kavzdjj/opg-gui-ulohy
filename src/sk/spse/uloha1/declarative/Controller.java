package sk.spse.uloha1.declarative;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField celsiusField;

    @FXML
    private TextField fahrenheitField;

    private boolean prebiehaPrevod = false;

    @FXML
    private void prevedZCelsius() {
        if (prebiehaPrevod) return;

        try {
            prebiehaPrevod = true;

            double c = Double.parseDouble(celsiusField.getText());
            double f = (c * 9/5) + 32;

            fahrenheitField.setText(String.format("%.2f", f));

        } catch (Exception e) {
            fahrenheitField.clear();
        } finally {
            prebiehaPrevod = false;
        }
    }

    @FXML
    private void prevedZFahrenheit() {
        if (prebiehaPrevod) return;

        try {
            prebiehaPrevod = true;

            double f = Double.parseDouble(fahrenheitField.getText());
            double c = (f - 32) * 5/9;

            celsiusField.setText(String.format("%.2f", c));

        } catch (Exception e) {
            celsiusField.clear();
        } finally {
            prebiehaPrevod = false;
        }
    }
}
