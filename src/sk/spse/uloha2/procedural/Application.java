package sk.spse.uloha2.procedural;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) {

        GridPane root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);

        // 1. riadok
        Label menoLabel = new Label("Užívateľské meno:");
        TextField menoField = new TextField();
        menoField.setPromptText("zadaj meno");

        root.add(menoLabel, 0, 0);
        root.add(menoField, 1, 0);

        // 2. riadok
        Label hesloLabel = new Label("Heslo:");
        PasswordField hesloField = new PasswordField();
        hesloField.setPromptText("zadaj heslo");

        root.add(hesloLabel, 0, 1);
        root.add(hesloField, 1, 1);

        // 3. riadok
        Label pohlavieLabel = new Label("Pohlavie:");

        RadioButton muzRadio = new RadioButton("Muž");
        RadioButton zenaRadio = new RadioButton("Žena");

        ToggleGroup pohlavieGroup = new ToggleGroup();
        muzRadio.setToggleGroup(pohlavieGroup);
        zenaRadio.setToggleGroup(pohlavieGroup);

        HBox radioBox = new HBox(15, muzRadio, zenaRadio);

        root.add(pohlavieLabel, 0, 2);
        root.add(radioBox, 1, 2);

        // 4. riadok - separator (spojené stĺpce)
        Separator separator = new Separator();
        root.add(separator, 0, 3, 2, 1);

        // 5. riadok - tlačidlá (spojené stĺpce)
        Button registrovatBtn = new Button("Registrovať");
        Button zavrietBtn = new Button("Zavrieť");

        HBox buttonBox = new HBox(15, registrovatBtn, zavrietBtn);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);

        root.add(buttonBox, 0, 4, 2, 1);

        // AKCIA Registrovať
        registrovatBtn.setOnAction(e -> {

            String meno = menoField.getText();
            String heslo = hesloField.getText();
            RadioButton selected = (RadioButton) pohlavieGroup.getSelectedToggle();

            if (selected == null) {
                return;
            }

            String pohlavie = selected.getText();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registrácia užívateľa");
            alert.setHeaderText("Registrácia prebehla úspešne");
            alert.setContentText("Užívateľ " + meno + " (" + pohlavie +
                    ") s heslom " + heslo + " bol pridaný do systému");

            alert.showAndWait();
        });

        // AKCIA Zavrieť
        zavrietBtn.setOnAction(e -> Platform.exit());

        Scene scene = new Scene(root);
        stage.setTitle("Procedural Application 2");
        stage.setScene(scene);
        stage.show();
    }
}
