import javafx.scene.image.ImageView;

public class TNT {

    private ImageView tnt;

    public TNT(){
        
        this.tnt = null;
    }

    void generateTNT(){

        tnt = new ImageView("pic/TNT.png");
    }

    public ImageView getTNT(double x, double y){

        generateTNT();
        tnt.setFitHeight(60);
        tnt.setFitWidth(50);
        tnt.setX(x);
        tnt.setX(y);
        return tnt;

    }

}