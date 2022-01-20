import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TimerAnimation {
    private int up;
    private int down;
    private ImageView coin;
    private ImageView will;
    private ImageView orc;
    private ImageView rocket;
    private ImageView axe;
    private ImageView boss;
    // private ImageView chest;
    private ImageView ele;
    private ImageView tnt;
    private MyTimer timer1;
    // private MyTimer2 timer2;
    private MyTimer2 mytime2;
    private MyTimer3 mytime3;
    private MyTimer33 timer33;
    private MyTimer44 timer44;
    private MyTimer66 timer66;
    private MyTimer7 timer7;
    private MyTimer10 timer11;
    // private MyTimer4 mytime4;
    private MyTimer5 mytime5;
    private MyTimer6 mytimer6;
    private GamePlayController gpc;
    // private MyTimer8 timer8;
    // private Objectfactory factory;
    private MyTimer9 timer9;
    private MyTimer31 mytime31;
    private MyTimer21 mytime21;
    private ImageChange timerCh;
    private Label coinLabel;
    private int note;
    private ArrayList<ImageView> islands;
    private ArrayList<ImageView> Orcs;
    private int flag=0;
    private int flag2=0;
    private int flagTwo=0;
    private final ImageGenerator imGen;
    private Collision col;
    
    // private Tester t;
    
    private Image smashedWill ;
    // private Image Will = new Image(getClass().getResourceAsStream("Will.png"));
    private Image openChest;
    // private Image stars = new Image(getClass().getResourceAsStream("stars.png"));
    private Image blasted_tnt; 
    private Image smashed_orc;
    private Image ele2;
    private Image smashed_boss;

    public TimerAnimation(){
            timer1 = new MyTimer();
            mytime2 = new MyTimer2();
            mytime3 = new MyTimer3();
            // timer2 = new MyTimer2();
            timer33 = new MyTimer33();
            timer44 = new MyTimer44();
            mytime5 = new MyTimer5();
            timer66 = new MyTimer66();
            timer7 = new MyTimer7();
            // timer8 = new MyTimer8();
            timer9 = new MyTimer9();
            timerCh = new ImageChange();
            mytime31 = new MyTimer31();
            mytime21 = new MyTimer21();
            timer11 = new MyTimer10();
            // t = new Tester();
            imGen = new ImageGenerator();
            loadImages();
            col = new Collision();
            // mytime4 = new MyTimer4();
            mytimer6 =new MyTimer6();
            // factory = new Objectfactory();
            
    }
    public void loadImages(){
        smashedWill = imGen.getSmashedWill();
        openChest = imGen.getOpenChest();
        blasted_tnt = imGen.getBlastedTNT();
        smashed_orc = imGen.getSmashedOrc();
        smashed_boss = imGen.getSmashedBoss();
    }
    
    public void setImages(ImageView ele,Image ele2) {
        this.ele = ele;
        this.ele2 = ele2;
    }
    public Image getOpenChest(){
        return openChest;
    }
    public Image getSmashedOrc(){
        return smashed_orc;
    }
    
    public void changeImage(ImageView first, Image second) {
        first.setImage(second);
    }
    public void setCoin(ImageView coin){
        this.coin=coin;
    }
    public void setTNT(ImageView tnt){
        this.tnt=tnt;
    }
    public void setWill(ImageView will){
        this.will=will;
    }
    public void setRocket(ImageView rocket){
        this.rocket=rocket;
    }
    public void setAxe(ImageView axe){
        this.axe=axe;
    }
    public void setOrc(ImageView orc){
        this.orc=orc;
    }
    public void setOrcs(ArrayList<ImageView> Orcs){
        this.Orcs=Orcs;
    }
    public void setOrcList(ArrayList<ImageView> arr){
        this.islands=arr;
    }
    public  void startCoinHandler(){
        this.timer1.start();
    }
    public void bossAction(){
        this.timer11.start();
    }
    public void startSmashHandler(){
        // this.timer2.start();
        // changeImageAnimation(will, smashedWill);
        this.timerCh.start();
    }
    public void pushOrc(){
        this.timer7.start();
    }
    public void openChest(){
        // this.timer5.start();
        // changeImageAnimation(this.chest, this.openChest);
        this.timerCh.start();
    }
    public void moveDown(){
        this.mytime2.start();
    }
    public void moveUp(){
        this.mytime3.start();
    }
    public void RocketFunc(){
        this.mytime5.start();
    }
    public void AxeFunc(){
        this.mytimer6.start();
    }
    public void down(){
        this.timer44.start();
    }
    public void blast(){
        this.timer66.start();
    }
    public void setBoss(ImageView boss){
        this.boss=boss;
    }
    public void setCoinData(Label coinLabel,int coin){
        this.coinLabel=coinLabel;
        this.note=coin;
    }
    public void goDown(){
        this.mytime21.start();
    }
    public Boolean detectCollision2(ImageView first, ImageView second) {
        try{
            if ( first.getY()<second.getY()+second.getFitHeight() && first.getX()+first.getFitWidth()>second.getX() && first.getX()<second.getX()+second.getFitWidth() ) {
                return true;
            }
        else{
            return false;
        }
        }
        catch(Exception e){
            return false;
        }
    }
    public void fall(){
        // 
        timerCh.start();
        flagTwo=1;
    }

    
    private class MyTimer extends AnimationTimer{
        private long prevTime = 0;
        @Override
        public void handle(long now) {
            long diff6 = now - prevTime;
        if(diff6>1e4){
            prevTime = now ;
            
            coin.setRotate(coin.getRotate()-8);
            coin.setY(coin.getY()-10);
            if(coin.getY()<=120){
                coin.setVisible(false);
                note+=1;
                App.db.setCoins(note);
                coinLabel.setText(Integer.toString(note));
                timer1.stop();
            }
        }
        }
    }

    private class MyTimer33 extends AnimationTimer{
        private long prevTime3 = 0;
        @Override
        public void handle(long now) {
            long diff3 = now - prevTime3;
            if(diff3>1e2){
                prevTime3 = now ;
                orc.setY(orc.getY()+5);
            }
            for(int i=0;i<4;i++)
            {
                if(detectCollision2(islands.get(i),orc)){
                    // will.setY(will.getY()-150);
                    System.out.println("Hello2");
                    if(flag2!=1){
                        timer33.stop();
                        down=0;
                        up=1;
                        timer44.start();
                    }
                    
                }
        }
        }
    }

    private class MyTimer44 extends AnimationTimer{
        private long prevTime3 = 0;
        @Override
        public void handle(long now) {
            long diff2 = now - prevTime3;
            if(diff2>1e2){
                prevTime3 = now ;
                orc.setY(orc.getY()-5);
                System.out.println("Hello1");
            }
            if(orc.getY()<=100){
                System.out.println("Hello3");
                timer44.stop();
                up=0;
                down=1;
                timer33.start();
            }
        }
    }

    
    private class ImageChange extends AnimationTimer{
        private long prevTime2 = 0;
        @Override
        public void handle(long now) {
            long diff2 = now - prevTime2;
        if(diff2>1e6){
            prevTime2 = now ;
            changeImage(ele, ele2);
            if(flagTwo==1){
                flagTwo=0;
                timerCh.stop();
                timer9.start();
            }
        }
        timerCh.stop();
        }
        
    }
    private class MyTimer66 extends AnimationTimer{
        private long prevTime2 = 0;
        @Override
        public void handle(long now) {
            long diff2 = now - prevTime2;
        if(diff2>1e6){
            prevTime2 = now ;
            changeImage(tnt,blasted_tnt);
            changeImage(will, smashedWill);
            flag=1;
        }
        if(flag==1 && tnt.getFitHeight()<=200){
            tnt.setFitHeight(tnt.getFitHeight()+5);
            tnt.setFitWidth(tnt.getFitWidth()+5);
            tnt.setY(tnt.getY()-5);
            tnt.setX(tnt.getX()-0.25);
        }
        else if(flag==2){
            timer66.stop();
        }
        else if(tnt.getFitHeight()>200){
            flag=2;
        }
        
        }
    }

    private class MyTimer7 extends AnimationTimer{
        private long prevTime2 = 0;
        @Override
        public void handle(long now) {
            long diff2 = now - prevTime2;
        if(diff2>1e2){
            prevTime2 = now ;
            orc.setX(orc.getX()+5);
        }
        if(diff2>1e14){
            System.out.println("Alola");
            timer7.stop();
            for(int i=0;i<islands.size();i++){
                if(!detectCollision2(islands.get(i),orc)){
                    flag2=1;
                    timer33.start();
                }
            }
            
        }
        }
    }
    private class MyTimer9 extends AnimationTimer{
        private long prevTime9 = 0;
        @Override
        public void handle(long now) {
            long diff2 = now - prevTime9;
        if(diff2>1e2){
            prevTime9 = now ;
            orc.setX(orc.getX()+1);
            orc.setY(orc.getY()+5);
            orc.setRotate(orc.getRotate()+8);
        
        }
        }
    }
    private class MyTimer21 extends AnimationTimer{
        private long prevTime2 = 0;
        @Override
        public void handle(long now) {
            long diff2 = now - prevTime2;
            if(diff2>1e2){
                prevTime2 = now ;
                boss.setY(boss.getY()+5);
                
            }
            for(int i=0;i<islands.size();i++)
            {
                
                if(col.detectCollision2(islands.get(i),boss)){    
                    // will.setY(will.getY()-150);
                    mytime21.stop();
                    // a2=0;
                    // a3=1;
                    mytime31.start();
                }
            }
        }
    }
    private class MyTimer31 extends AnimationTimer{
        private long prevTime3 = 0;
        @Override
        public void handle(long now) {
            long diff2 = now - prevTime3;
            if(diff2>1e2){
                prevTime3 = now ;
                boss.setY(boss.getY()-5);
                
            }
            if(boss.getY()<=100){
                
                mytime31.stop();
                // a3=0;
                // a2=1;
                mytime21.start();
            }
        }
    }

    private class MyTimer2 extends AnimationTimer{
        private long prevTime2 = 0;
        @Override
        public void handle(long now) {
            long diff2 = now - prevTime2;
            if(diff2>1e2){
                prevTime2 = now ;
                will.setY(will.getY()+5);
                
            }
            for(int i=0;i<islands.size();i++)
            {
                
                if(col.detectCollision2(islands.get(i),will)){    
                    // will.setY(will.getY()-150);
                    mytime2.stop();
                    // a2=0;
                    // a3=1;
                    mytime3.start();
                }
            }
        }
    }
    private class MyTimer3 extends AnimationTimer{
        private long prevTime3 = 0;
        @Override
        public void handle(long now) {
            long diff2 = now - prevTime3;
            if(diff2>1e2){
                prevTime3 = now ;
                will.setY(will.getY()-5);
                
            }
            if(will.getY()<=100){
                
                mytime3.stop();
                // a3=0;
                // a2=1;
                mytime2.start();
            }
        }
    }
    
    private class MyTimer5 extends AnimationTimer{
        private long prevTime5 = 0;

        @Override
        public void handle(long now) {
            long diff2 = now - prevTime5;
    
            if(diff2>1e7){
                prevTime5 = now ;
                rocket.setVisible(true);
                rocket.setX(rocket.getX()+2);
                // Rocket.get(Rocket.size()-1).setX(Rocket.get(Rocket.size()-1).getX()+5);
                if(rocket.getX()>1100 && GamePlayController.AxeFlag==0){
                    GamePlayController.rocketFlag=1;
                    rocket.setX(will.getX());
                    rocket.setY(will.getY());
                }
                
            }
            
        }
    }

    // private class MyTimer4 extends AnimationTimer{
    //     private long prevTime4 = 0;
    //     @Override 
    //     public void handle(long now) {
    //         long diff4 = now - prevTime4;
    //     if(diff4>1e7){
    //         prevTime4 = now ;
    //         rocket=factory.createImage((int)will.getX(),(int)will.getY(),50,75,"pic/Rocket_with_flare.png");
    //         // Rocket.add(rocket);
    //         GamePlayController.rocketFlag=0;
    //         GamePlayController.playGameAp.getChildren().add(rocket);
    //         GamePlayController.flag=1;
    //     }
    //     if(flag==1)
    //     {
    //         mytime4.stop();
    //         mytime5 = new MyTimer5();
    //         mytime5.start();
    //         // timera.add(mytime5);
            
    //     }
    //     }
    // }

    private class MyTimer6 extends AnimationTimer{
        private long prevTime6 = 0;
        @Override
        public void handle(long now) {
            long diff6 = now - prevTime6;
        if(diff6>1e2){
            prevTime6 = now ;
            axe.setVisible(true);
            axe.setRotate(axe.getRotate()+20);
            axe.setX(axe.getX()+10);
            if(axe.getX()>=900){
                mytimer6.stop();
                axe.setVisible(false);
                // mytimer7.start();
            }
        }
        }
    }

    private class MyTimer10 extends AnimationTimer{
        private long prevTime10 = 0;
        @Override
        public void handle(long now) {
            long diff10 = now - prevTime10;
        if(diff10>1e2){
            prevTime10 = now ;
            changeImage(boss,smashed_boss);
            boss.setX(boss.getX()+1);
            boss.setY(boss.getY()+5);
            boss.setRotate(boss.getRotate()+1);
        }
        }
    }
}
