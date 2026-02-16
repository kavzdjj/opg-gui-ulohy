package sk.spse.uloha4.procedural;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class Application extends javafx.application.Application {

    private final Random random = new Random();

    private VBox vbox1;
    private VBox vbox2;
    private VBox vbox3;
    private VBox vbox4;

    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();

        // ====== STRED ======
        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(4);

        vbox1 = createBox();
        vbox2 = createBox();
        vbox3 = createBox();
        vbox4 = createBox();

        tilePane.getChildren().addAll(vbox1, vbox2, vbox3, vbox4);

        root.setCenter(tilePane);

        // ====== SPODOK ======
        Label quote = new Label(
                "\"In the future, everyone will be world-famous for 15 minutes\" - Andy Warhol"
        );

        Button randomizeBtn = new Button("Randomize");
        Button closeBtn = new Button("Close");

        randomizeBtn.setOnAction(e -> randomize());
        closeBtn.setOnAction(e -> Platform.exit());

        TilePane buttonPane = new TilePane();
        buttonPane.setAlignment(Pos.CENTER_RIGHT);
        buttonPane.setHgap(10);
        buttonPane.getChildren().addAll(randomizeBtn, closeBtn);

        VBox bottomBox = new VBox(10, quote, buttonPane);
        bottomBox.setPadding(new Insets(10));

        root.setBottom(bottomBox);

        Scene scene = new Scene(root, 800, 400);

        stage.setTitle("Procedural Application 4");
        stage.setScene(scene);
        stage.show();
    }

    private VBox createBox() {
        Image image = new Image(getClass().getResourceAsStream("/sk/spse/uloha4/procedural/soup.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(150);
        imageView.setPreserveRatio(true);

        VBox vbox = new VBox(imageView);
        vbox.setAlignment(Pos.CENTER);
        return vbox;
    }

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
