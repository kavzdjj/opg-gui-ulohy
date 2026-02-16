package sk.spse.uloha3.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class Controller {

    @FXML
    private void zavriet() {
        Platform.exit();
    }
}
