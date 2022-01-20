import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Node;

public class RecordController implements Initializable{

    @FXML
    private TextField TextField;

    @FXML
    private ImageView chest;

    @FXML
    private ImageView rocket;

    @FXML
    private Button startButton;

    @FXML
    private ImageView welCome;

    @FXML
    private ImageView willHero;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private String currentUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Animmations.fadein(welCome, 1.0, 2.0, 3.0);
        Animmations.scale(welCome, 'x', 0.1, 500, 0);

        Animmations.trasnlate(willHero, 'y', -70, 1100, 0, true);
        Animmations.trasnlate(chest, 'y', -60, 700, 0, true);

        Animmations.trasnlate(rocket, 'x', 1250, 2000, 2, false);


    }
    
    @FXML
    void startNewGame(MouseEvent event) throws IOException {

        this.currentUser = TextField.getText();
        App.currentUser = this.currentUser;

        App.db = new Database();
        App.dList.addDatabase(currentUser, App.db);

        root = FXMLLoader.load(getClass().getResource("Themes.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1100, 600);
        stage.setScene(scene);
        stage.show();

    }
    
}