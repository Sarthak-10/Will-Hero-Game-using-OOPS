import javafx.scene.image.ImageView;

public class StandardGreen extends Orcs{

    private ImageView greenOrc;

    public StandardGreen(){

        this.greenOrc = null;
    }

    void generateGreenOrc(){

        this.greenOrc = new ImageView("pic/Standard_Green_Orc.png");

    }

    public ImageView getGreenOrc(double x, double y){

        generateGreenOrc();
        greenOrc.setFitHeight(60);
        greenOrc.setFitWidth(50);
        greenOrc.setX(x);
        greenOrc.setX(y);
        return greenOrc;

    }

}
