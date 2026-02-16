package sk.spse.uloha1.procedural;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    private boolean prebiehaPrevod = false;

    @Override
    public void start(Stage stage) {

        TextField celsiusField = new TextField();
        TextField fahrenheitField = new TextField();

        celsiusField.setOnKeyTyped(e -> {
            if (prebiehaPrevod) return;

            try {
                prebiehaPrevod = true;

                double c = Double.parseDouble(celsiusField.getText());
                double f = (c * 9/5) + 32;

                fahrenheitField.setText(String.format("%.2f", f));

            } catch (Exception ex) {
                fahrenheitField.clear();
            } finally {
                prebiehaPrevod = false;
            }
        });

        fahrenheitField.setOnKeyTyped(e -> {
            if (prebiehaPrevod) return;

            try {
                prebiehaPrevod = true;

                double f = Double.parseDouble(fahrenheitField.getText());
                double c = (f - 32) * 5/9;

                celsiusField.setText(String.format("%.2f", c));

            } catch (Exception ex) {
                celsiusField.clear();
            } finally {
                prebiehaPrevod = false;
            }
        });

        HBox riadok1 = new HBox(10,
                new Label("Celsius:"),
                celsiusField,
                new Label("°C")
        );
        riadok1.setAlignment(Pos.CENTER);

        HBox riadok2 = new HBox(10,
                new Label("Fahrenheit:"),
                fahrenheitField,
                new Label("°F")
        );
        riadok2.setAlignment(Pos.CENTER);

        VBox root = new VBox(15, riadok1, riadok2);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 350, 150);

        stage.setTitle("Procedural Application 1");
        stage.setScene(scene);
        stage.show();
    }
}
