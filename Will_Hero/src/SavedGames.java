import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Node;


public class SavedGames {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private AnchorPane savedGameAp;
    @FXML
    private ImageView play;
    @FXML
    private ImageView newGame;

    @FXML
    void resume(MouseEvent event) throws ClassNotFoundException, IOException{
        
        App.deserialize();
        App.db = App.dList.getDatabase(App.currentUser);
        System.out.println(App.dList.getSize());

        root = FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         
        AnchorPane rootanchor =((AnchorPane) root);
        rootanchor.setStyle(App.db.getTheme());
        
        scene = new Scene(root, 1100, 600);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void generateNewGameButton(MouseEvent event) throws Exception{

        App.serialize();
        
        // App.db=new Database();
        // App.dList.addDatabase("1", App.db);

        root = FXMLLoader.load(getClass().getResource("Mainpage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1100, 600);
        stage.setScene(scene);
        stage.show();

        
    }
    

}

