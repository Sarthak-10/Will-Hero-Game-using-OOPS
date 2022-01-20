import javafx.scene.image.ImageView;

public class StandardRed extends Orcs{

    private ImageView redOrc;

    public StandardRed(){

        this.redOrc = null;
    }

    void generateRedOrc(){

        this.redOrc = new ImageView("pic/Standard_Red_Orc.png");

    }
    
    public ImageView getGreenOrc(double x, double y){

        generateRedOrc();
        redOrc.setFitHeight(60);
        redOrc.setFitWidth(50);
        redOrc.setX(x);
        redOrc.setX(y);
        return redOrc;

    }

}
