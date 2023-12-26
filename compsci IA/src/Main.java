//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application{
    Button button;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
            primaryStage.setTitle("Main window");
            button = new Button();
            button.setText("Click Me");

            StackPane layout = new StackPane();
            layout.getChildren().add(button);

            Scene scene = new Scene(layout, 1920, 1080);
            primaryStage.setScene (scene);
            primaryStage.show();

    }
}