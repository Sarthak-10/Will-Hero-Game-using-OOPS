// import javafx.animation.ScaleTransition;
// import javafx.animation.TranslateTransition;
// import javafx.fxml.FXML;
// import javafx.fxml.Initializable;
// import javafx.scene.image.ImageView;
// import javafx.scene.input.MouseEvent;
// import java.net.URL;
// import java.util.ResourceBundle;

// public class MainSceneController implements Initializable {
    
//     TranslateTransition tr, tr1, tr3;
//     ScaleTransition sc;
//     private Player player;
//     @FXML
//     private ImageView tnt;
//     @FXML
//     private ImageView c1;
//     @FXML
//     private ImageView c2;
//     @FXML
//     private ImageView c3;
//     @FXML
//     private ImageView will;
//     @FXML
//     private ImageView gOrc;
//     @FXML
//     private ImageView treasure;
//     @FXML
//     private ImageView star;
//     @FXML
//     private ImageView isl1;
//     @FXML
//     private ImageView isl2;

//     public MainSceneController() {
//         player = new Player(new MainSceneController());
//     }
//     @Override
//     public void initialize(URL location, ResourceBundle resources) {

//         tr = CAnimations.translate(will, 'y', -100.0, 400.0, 1, 1);
//         sc = CAnimations.scale(will, 'y', -0.2, 400, 0, 1);
//         CAnimations.translate(gOrc, 'y', -145.0, 500.0, 1, 1);
//         tr1 = CAnimations.translate(treasure, 'y', -30, 600.0, 1, 1);
//         tr3 = CAnimations.translate(tnt, 'y', -30, 700.0, 1, 1);
//     }

//     @FXML
//     void moveFrwd(MouseEvent event) {
//         player.move(will,tr,sc,tr1,tr3);
//     }

//     public ImageView getWill() {
//         return will;
//     }
//     public ImageView getGOrc() {
//         return gOrc;
//     }
//     public ImageView getTreasure() {
//         return treasure;
//     }
//     public ImageView getTnt() {
//         return tnt;
//     }
//     public ImageView getC1() {
//         return c1;
//     }
//     public ImageView getC2() {
//         return c2;
//     }
//     public ImageView getC3() {
//         return c3;
//     }
//     public ImageView getStar() {
//         return star;
//     }
//     public ImageView getIsl1() {
//         return isl1;
//     }
//     public ImageView getIsl2() {
//         return isl2;
//     }
// }