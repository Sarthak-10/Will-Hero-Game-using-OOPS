import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App extends Application {

    static Database db;
    static DatabaseList dList;
    static String currentUser;

    public static void main(String[] args) {
        launch(args);
    }

    public static void serialize() throws IOException {

        ObjectOutputStream out=null;

        try {
            out = new ObjectOutputStream (new FileOutputStream("Datafile.txt"));
            out.writeObject(dList);
        }
        finally {
            out.close();
            
        }
        
    }
    
    public static void deserialize() throws ClassNotFoundException, FileNotFoundException, IOException {
        ObjectInputStream in = null;
        try {
            
            in=new ObjectInputStream (new FileInputStream("Datafile.txt"));
            dList=(DatabaseList)in.readObject();
            in.close();
        }
        catch (FileNotFoundException e){
            dList=new DatabaseList();
        }
        catch (NullPointerException e) {
            dList=new DatabaseList();
            
        }
        catch(ClassNotFoundException e){
            dList=new DatabaseList();
        }
        catch(Exception e){
            dList=new DatabaseList();
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //dList = new DatabaseList();

        try {

           deserialize();
            Parent root = FXMLLoader.load(getClass().getResource("Mainpage.fxml"));
            Image icon = new Image("pic/Will.png");
            primaryStage.getIcons().add(icon);
            Scene scene = new Scene(root, 1100, 600);

            primaryStage.setTitle("Will Hero");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
        
    
    }

}
