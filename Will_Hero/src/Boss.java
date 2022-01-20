import javafx.scene.image.ImageView;

public class Boss extends Orcs{

    private ImageView boss;

    public Boss(){

        this.boss = null;
    }
    
    void generateBoss(){

        this.boss = new ImageView("pic/Boss.png");

    }

    public ImageView getBoss(double x, double y){
        
        generateBoss();
        boss.setFitHeight(60);
        boss.setFitWidth(50);
        boss.setX(x);
        boss.setX(y);
        return boss;

    }

}
