import javafx.scene.image.ImageView;

public abstract class Orcs {
    
    private ImageView orc;

    public Orcs(){
        this.orc = null;
    }

    public void generateOrc(int n){

        switch (n) {

            case 1: orc = new ImageView("pic/Standard_Red_Orc.png");
                        orc.setFitHeight(48);
                        orc.setFitWidth(65);
                    break;
            case 2: orc = new ImageView("pic/Standard_Green_Orc.png");
                        orc.setFitHeight(48);
                        orc.setFitWidth(65);
                    break;
            default:
                    break;

        }

    }

    public ImageView getOrc(double x, double y){

        int n = (int)Math.floor(Math.random()*(2-1+1)+1);
        generateOrc(n);
        orc.setX(x);
        orc.setY(y);
        return orc;
    }

}
