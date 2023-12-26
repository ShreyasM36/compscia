//*Asked ChatGPT to code this for me to see if it works or weather it is my coding problem //*

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class testing extends Application {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Multi-Screen JavaFX App");

        // Initial screen with buttons
        Button button1 = new Button("Go to Screen 1");
        button1.setOnAction(e -> goToScreen1());

        Button button2 = new Button("Go to Screen 2");
        button2.setOnAction(e -> goToScreen2());

        StackPane initialLayout = new StackPane();
        initialLayout.getChildren().addAll(button1, button2);

        Scene initialScene = new Scene(initialLayout, 1920, 1080);
        primaryStage.setScene(initialScene);

        primaryStage.show();
    }

    private void goToScreen1() {
        Button backButton = new Button("Go Back");
        backButton.setOnAction(e -> primaryStage.setScene(primaryStage.getScene()));

        StackPane screen1Layout = new StackPane();
        screen1Layout.getChildren().add(backButton);

        Scene screen1Scene = new Scene(screen1Layout, 1920, 1080);
        primaryStage.setScene(screen1Scene);
    }

    private void goToScreen2() {
        Button backButton = new Button("Go Back");
        backButton.setOnAction(e -> primaryStage.setScene(primaryStage.getScene()));

        StackPane screen2Layout = new StackPane();
        screen2Layout.getChildren().add(backButton);

        Scene screen2Scene = new Scene(screen2Layout, 1920, 1080);
        primaryStage.setScene(screen2Scene);
    }
}