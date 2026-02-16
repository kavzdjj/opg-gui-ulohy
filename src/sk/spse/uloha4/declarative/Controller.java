package sk.spse.uloha4.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.util.Random;

public class Controller {

    @FXML
    private VBox vbox1;

    @FXML
    private VBox vbox2;

    @FXML
    private VBox vbox3;

    @FXML
    private VBox vbox4;

    private final Random random = new Random();

    @FXML
    private void closeApp() {
        Platform.exit();
    }

    @FXML
    private void randomize() {
        vbox1.setStyle("-fx-background-color: " + getRandomColor() + ";");
        vbox2.setStyle("-fx-background-color: " + getRandomColor() + ";");
        vbox3.setStyle("-fx-background-color: " + getRandomColor() + ";");
        vbox4.setStyle("-fx-background-color: " + getRandomColor() + ";");
    }

    private String getRandomColor() {
        return String.format("#%02x%02x%02x",
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256));
    }
}
