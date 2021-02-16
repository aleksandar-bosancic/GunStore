import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class UILoader extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root;
        try {
            root = FXMLLoader.load(this.getClass().getResource("Login_scene.fxml"));
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.getScene().getWindow().hide();
            stage.show();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
