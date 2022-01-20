
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.IOException;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class LoadGamesController {

    @FXML
    private TextField myTextField;

    @FXML
    private Button submitButton;

    @FXML
    private Button Snocount;

    @FXML
    private Button coinscount;

    @FXML
    private Button stepscount;

    private String name;
    
    @FXML
    private TextField gamenoTextFeild;
    
    @FXML
    private Button Load;

    @FXML
    private AnchorPane laodGameAp;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void readText(MouseEvent event) {
        
        name = myTextField.getText();
        App.currentUser = name;

        DisplayGames();
    }


    public void DisplayGames(){

        int c = App.dList.getListsize(name);

        for( int i = 0, x =50; i<c ; i++, x+=50){

            Database obj = App.dList.getDatabase(name, i);

            Text num  = new Text( Integer.toString(i+1));
            num.setLayoutX(Snocount.getLayoutX());
            num.setLayoutY(Snocount.getLayoutY()+x);
            num.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, 16));
            laodGameAp.getChildren().add(num);
            
            Text steps = new Text(Integer.toString(obj.getSteps()));
            steps.setLayoutX(stepscount.getLayoutX());
            steps.setLayoutY(stepscount.getLayoutY()+x);
            steps.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, 16));
            laodGameAp.getChildren().add(steps);

            Text coins = new Text(Integer.toString(obj.getCoins()));
            coins.setLayoutX(coinscount.getLayoutX());
            coins.setLayoutY(coinscount.getLayoutY()+x);
            coins.setFont(Font.font("Roboto Blacak", FontWeight.BOLD, 16));
            laodGameAp.getChildren().add(coins);

        }
       
    }

    @FXML
    void resumeThatGame(MouseEvent event) throws IOException{

        int gameno = Integer.parseInt(gamenoTextFeild.getText());
        App.db = App.dList.getDatabase(name, gameno-1);

        root = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         
        AnchorPane rootanchor =((AnchorPane) root);
        rootanchor.setStyle(App.db.getTheme());
        
        scene = new Scene(root, 1100, 600);
        stage.setScene(scene);
        stage.show();

    }
}
