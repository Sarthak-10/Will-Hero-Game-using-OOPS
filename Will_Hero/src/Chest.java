import javafx.scene.image.ImageView;

public class Chest {
    
    private ImageView chest;

    public Chest(){

        this.chest = null;
    }

    public void generateChest(int n){

        switch (n) {

            case 1: chest = new ImageView("pic/pinkchest.jpg");
                    chest.setFitHeight(48);
                    chest.setFitWidth(65);
                break;

            case 2: chest = new ImageView("pic/Weapon_Chest.png");
                    chest.setFitHeight(50);
                    chest.setFitWidth(60);
                break;
            
            default:
                break;
        }

    }

    public ImageView getChest(double x, double y){

        int n = (int)Math.floor(Math.random()*(2-1+1)+1);
        generateChest(n);
        chest.setX(x);
        chest.setY(y);
        return chest;
        
    }

}
