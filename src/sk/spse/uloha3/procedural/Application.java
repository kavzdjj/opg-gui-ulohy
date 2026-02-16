package sk.spse.uloha3.procedural;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(15));

        // TOP
        Label title = new Label("Stredná priemyselná škola elektrotechnická, Prešov");
        title.setStyle("-fx-font-size: 18px;");
        BorderPane.setAlignment(title, Pos.CENTER);
        root.setTop(title);

        // LEFT
        ImageView imageView = new ImageView(new Image("spse.png"));
        imageView.setFitWidth(180);
        imageView.setPreserveRatio(true);
        root.setLeft(imageView);

        // CENTER
        TextArea textArea = new TextArea(
                "Vážení rodičia a milí žiaci základných škôl,\n\n" +
                        "radi by sme Vás privítali v priestoroch našej školy\n" +
                        "dňa 10. 02. 2026 (utorok) od 13.00 do 17.00 h na\n" +
                        "Dni otvorených dverí, kde by sme Vám chceli\n" +
                        "predstaviť naše študijné odbory."
        );
        textArea.setEditable(false);
        textArea.setWrapText(true);

        Hyperlink link = new Hyperlink("https://www.spse-po.sk");

        Button button = new Button("Beriem na vedomie");
        button.setOnAction(e -> Platform.exit());

        VBox centerBox = new VBox(10, textArea, link, button);
        centerBox.setAlignment(Pos.CENTER_LEFT);

        root.setCenter(centerBox);

        Scene scene = new Scene(root, 650, 350);

        stage.setTitle("Procedural Application 3");
        stage.setScene(scene);
        stage.show();
    }
}
