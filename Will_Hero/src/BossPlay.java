import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class BossPlay implements Initializable{
   
    @FXML
    private AnchorPane BossAp;
    private TimerAnimation timer10;
    private ImageView will;
    private Timeline t;
    private ImageView boss;
    private ImageView Island1;
    private ImageView Island2;
    private ImageView gameOver;
    private MyTimer mytime;
    private AllTimer allTime;
    private ArrayList<ImageView> list; 
    private ImageView axe;
    static int BossPower;
    private Collision col;
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = new ArrayList<ImageView>();
        will = new ImageView("pic/Will.png"); setImage(will,177,270,68,57);
        Island1 = new ImageView("pic/greenIsland3.png");setImage(Island1, 109, 338, 174, 400);
        Island2 = new ImageView("pic/greenIsland6.png");setImage(Island2, 588, 338, 310, 316);
        boss = new ImageView("pic/Boss.png"); setImage(boss, 682, 203, 135, 180);
        gameOver = new ImageView("pic/Game_Over.png"); setImage(gameOver, 376,0,252,401);
        col=new Collision();
        gameOver.setVisible(false);
        list.add(Island1);
        list.add(Island2);
        allTime = new AllTimer();
        mytime= new MyTimer();
        timer10 = new TimerAnimation();
        timer10.moveDown();
        timer10.setWill(will);
        timer10.setOrcList(list);
        timer10.setBoss(boss);
        timer10.goDown();
        axe = new ImageView("pic/Throwing_axe.png");
        setImage(axe,(int)will.getX(),(int)will.getY(),50,70);
        axe.setVisible(false);
        timer10.setAxe(axe);
        BossPower = 100;
        allTime.start();
    }
    @FXML
    void moveFrwd(MouseEvent event) {
        System.out.println("move frwd");
        t = new Timeline(
                new KeyFrame(
                        javafx.util.Duration.millis(1),
                        ae -> {
                            mytime.start();
                            
                        }
                )
        );
        t.play();
    }

    void setImage(ImageView img , double x, double y, double h, double w){

        img.setFitHeight(h);
        img.setFitWidth(w);
        img.setX(x);
        img.setY(y);
        BossAp.getChildren().add(img);

    }
    
    private class MyTimer extends AnimationTimer{
        private long prevTime = 0;
        @Override
        public void handle(long now) {
            long diff = now - prevTime;
            
            if(diff>1e5){
                prevTime = now ;
                System.out.println("move frwd2");
                axe.setX(will.getX());
                axe.setY(will.getY());
                timer10.AxeFunc();
                BossPlay.BossPower-=20;

                if(BossPlay.BossPower<=0){
                    
                    timer10.bossAction();
                    gameOver.setVisible(true);
                }
                mytime.stop();
                // will.setX(will.getX()+5);
            }
            
            
        }
}

    private class AllTimer extends AnimationTimer{
        @Override
        public void handle(long now) {
            if(col.looseCollision(axe,boss)){
                boss.setOpacity(boss.getOpacity()-0.005);
                if(boss.getOpacity()<=0.5){
                    allTime.stop();
                }
            }
        }
    }

}



