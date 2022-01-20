import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Node;


public class GameOver {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView menu;

    @FXML
    private ImageView quit;

    @FXML
    private ImageView resurrect;
    @FXML
    private AnchorPane GameOverAp;

    @FXML
    void exit(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void menu(MouseEvent event) throws Exception {

        App.dList.DeletelastGame(App.currentUser);
        App.serialize();
        root = FXMLLoader.load(getClass().getResource("Mainpage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1100, 600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void resurrect(MouseEvent event) throws Exception{

        try {

            checkResurrection();

        } catch (InsufficientCoinException e) {

            System.out.println(e.getMessage());
            System.out.println("Switching to main scene");
            LoadMainMenu();

        } catch (InvalidRessurection e){

            System.out.println(e.getMessage());
            System.out.println("Switching to main scene");
            LoadMainMenu();

        }

        App.db.setResurrect(false);
        App.db.setCoins(App.db.getCoins()-30);

        root = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1100, 600);
         
        AnchorPane rootanchor = ((AnchorPane) root);
        rootanchor.setStyle(App.db.getTheme());

        stage.setScene(scene);
        stage.show();

    }


    public void checkResurrection() throws InsufficientCoinException, InvalidRessurection{

        if( App.db.canRessurect()==false){
            
            throw new InvalidRessurection("Invalid Ressurection\nCannot Ressurent more than once");
        }

        if(App.db.getCoins()<=30){

            throw new InsufficientCoinException("Invalid Ressurection\nInsuffecient Coins");
        }
    }

    public void LoadMainMenu() throws IOException{

        App.dList.DeletelastGame(App.currentUser);
        App.serialize();
        
        System.exit(0);
        root = FXMLLoader.load(getClass().getResource("Mainpage.fxml"));
        Stage stage = (Stage)GameOverAp.getScene().getWindow();
        stage.setScene(new Scene(root, 1100, 600));
        stage.show();

    }
}


