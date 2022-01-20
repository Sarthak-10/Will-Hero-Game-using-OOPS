import javafx.scene.image.ImageView;

public class Player{
    private ImageView player;
    private Objectfactory factory;
    
    public Player(){
        factory = new Objectfactory();
        this.player = factory.createImage(177,156,68,57,"pic/Will.png");
    }
    
    public ImageView getPlayer(){
        return this.player;
    }
}