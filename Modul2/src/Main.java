import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("com/modul2/view/AplikasiPenghitungBangunRuang.fxml"));
        primaryStage.setTitle("Aplikasi Penghitung Bangun Ruang");
        primaryStage.setScene(new Scene(root, 585, 265));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
