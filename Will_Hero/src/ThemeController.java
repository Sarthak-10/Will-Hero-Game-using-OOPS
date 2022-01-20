import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ThemeController implements Initializable{

    @FXML
    private ImageView Clouds;

    @FXML
    private ImageView beach;

    @FXML
    private ImageView beachlogo;

    @FXML
    private ImageView chooselogo;

    @FXML
    private ImageView clearSky;

    @FXML
    private ImageView clearskylogo;

    @FXML
    private ImageView cloudslogo;

    @FXML
    private ImageView evening;

    @FXML
    private ImageView eveninglogo;

    @FXML
    private ImageView nightMode;

    @FXML
    private ImageView nightmodelogo;

    @FXML
    private ImageView sunSet;

    @FXML
    private ImageView sunsetlogo;

    @FXML
    private ImageView themeslogo;

    @FXML
    private ImageView axe;

    @FXML
    private ImageView rocket;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private String theme;

    @FXML
    void changeThemetoClearsky(MouseEvent event) throws IOException  {

        theme = "-fx-background-image: url('pic/clouds.jpg'); -fx-background-size: cover;";
        Change(event, theme);
        
    }

    @FXML
    void changeThemetoBeach(MouseEvent event) throws IOException {

        theme = "-fx-background-image: url('pic/beach.jpg'); -fx-background-size: cover;";
        Change(event, theme);
    }

    @FXML
    void changeThemetoClouds(MouseEvent event) throws IOException {
        theme = "-fx-background-image: url('pic/bg2.jpg'); -fx-background-size: cover;";
        Change(event, theme);
    }

    @FXML
    void changeThemetoEvening(MouseEvent event) throws IOException {
        theme = "-fx-background-image: url('pic/evening.jpg'); -fx-background-size: cover;";
        Change(event, theme);
    }

    @FXML
    void changeThemetoNightmode(MouseEvent event) throws IOException {
        theme = "-fx-background-image: url('pic/nightmode.jpg'); -fx-background-size: cover;";
        Change(event, theme);
    }

    @FXML
    void changeThemetoSunset(MouseEvent event) throws IOException {
        theme = "-fx-background-image: url('pic/sunset.jpg'); -fx-background-size: cover;";
        Change(event, theme);
    }

    void Change(MouseEvent event, String theme) throws IOException{

        root = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1100, 600);

        AnchorPane rootanchor =((AnchorPane) root);
        rootanchor.setStyle(theme);
        App.db.setTheme(theme);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Animmations.trasnlate(chooselogo, 'x', 550, 1500, 4, false);
        Animmations.trasnlate(themeslogo, 'x', -550, 1500, 4, false);

        Animmations.trasnlate(beach, 'x', -1187, 2000, 2, false);
        Animmations.trasnlate(sunSet, 'x', -1169, 2000, 2, false);
        Animmations.trasnlate(evening, 'x', -1131, 2000, 2, false);
        Animmations.trasnlate(rocket, 'x', -1220, 2000, 2, false);

        Animmations.rotate(axe, 360);
        Animmations.trasnlate(axe, 'x', 1200, 2000, 2, false);
        Animmations.trasnlate(clearSky, 'x', 1092, 2000, 2, false);
        Animmations.trasnlate(Clouds, 'x', 1122, 2000, 2, false);
        Animmations.trasnlate(nightMode, 'x', 1169, 2000, 2, false);
        

        Animmations.scale(clearskylogo, 'x', 0.1, 500, 0);
        Animmations.scale(cloudslogo, 'x', 0.1, 500, 0);
        Animmations.scale(beachlogo, 'x', 0.1, 500, 0);
        Animmations.scale(eveninglogo, 'x', 0.1, 500, 0);
        Animmations.scale(sunsetlogo, 'x', 0.1, 500, 0);
        Animmations.scale(nightmodelogo, 'x', 0.1, 500, 0);
        
        
    }

}
