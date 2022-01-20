import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GamePlayController implements Initializable{
    TranslateTransition tr;
    @FXML
    private AnchorPane playGameAp;
    @FXML
    private ImageView pause;
    // private ImageView currWeapon;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private ArrayList<ImageView> list;
    private ArrayList<ImageView> Coin;
    private ArrayList<ImageView> TNT;
    private ArrayList<ImageView> Orcs;
    private ArrayList<ImageView> chests;
    private ImageView img;
    private ImageView will,rocket,axe;
    // private ArrayList<ImageView> Rocket;
    // private ArrayList<MyTimer5> timera;
    private Objectfactory factory;
    double x, y;
    Boolean flag1=false;
    Boolean flag2=false;
    private Collision col;
    private MyTimer mytime;

    // private MyTimer7 mytimer7;
    private AllTimer alltimer;
    private TimerAnimation timer10;
    private int steps;
    private int notes;
    private ImageGenerator imGen;
    private ProgressBar myProgressBar;
    private Label stepsLabel;
    private Label coinLabel;

    private double progress;
    private Timeline t;
    private ImageView c;
    // private int a2=0;
    // private int a3=0;
    static int flag=0;
    private Database db;
    static int rocketFlag=0;
    static int AxeFlag=0;
    private Player pl;
    // private RandomGenerator rgen;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        this.db=App.db;
        factory = new Objectfactory();
        pl = new Player();
        // rgen = new RandomGenerator();
        list = new ArrayList<ImageView>();
        Coin = new ArrayList<ImageView>();
        chests = new ArrayList<ImageView>();
        Orcs= new ArrayList<ImageView>();    
        TNT = new ArrayList<ImageView>(); 
        timer10 = new TimerAnimation();
        col = new Collision();  
        int x = 0;
        myProgressBar = new ProgressBar();
        stepsLabel = new Label();
        coinLabel = new Label();

        steps= db.getSteps();
        notes =  db.getCoins();
        progress = db.getProgress();
        AxeFlag = db.getAxe();
        rocketFlag = db.getRocket();
        

        System.out.println(steps+" "+progress);
        timer10.setCoinData(coinLabel, notes);
        myProgressBar.setPrefWidth(310);
        myProgressBar.setPrefHeight(33);
        myProgressBar.setLayoutX(43);
        myProgressBar.setLayoutY(32);
        myProgressBar.setStyle("-fx-accent: #00FF00;");
        myProgressBar.setProgress(progress);
        imGen = new ImageGenerator();
        stepsLabel.setPrefWidth(46);
        stepsLabel.setPrefHeight(35);
        stepsLabel.setLayoutX(377);
        stepsLabel.setLayoutY(32);
        
        stepsLabel.setStyle("-fx-text-fill: red");
        stepsLabel.setStyle("-fx-background-color: white;");
        stepsLabel.setFont(new Font(24));
        stepsLabel.setText(Integer.toString(steps));

        coinLabel.setPrefWidth(46);
        coinLabel.setPrefHeight(35);
        coinLabel.setLayoutX(1022);
        coinLabel.setLayoutY(32);
        coinLabel.setStyle("-fx-text-fill: red");
        coinLabel.setStyle("-fx-background-color: white;");
        coinLabel.setFont(new Font(24));
        coinLabel.setText(Integer.toString(notes));


        playGameAp.getChildren().add(stepsLabel);
        playGameAp.getChildren().add(myProgressBar);
        playGameAp.getChildren().add(coinLabel);
        
        for(int i = 0 ; i<5 ; i++, x+=300){

            img = factory.getImgage(70+x, 390);
            // c1=rgen.getImage(img.getX(), img.getY(), img.getFitHeight()/2, img.getFitWidth()/2);
            list.add(img);
            // playGameAp.getChildren().add(c1);
            playGameAp.getChildren().add(img);
            if(i>1){
                setCoins(img);
                setChest(img);
            }

        }
        will=pl.getPlayer();
        
        playGameAp.getChildren().add(will);
        axe=factory.createImage((int)will.getX(),(int)will.getY(),50,75,"pic/Throwing_axe.png");
        rocket=factory.createImage((int)will.getX(),(int)will.getY(),50,75,"pic/Rocket_with_flare.png");
        playGameAp.getChildren().add(axe);
        axe.setVisible(false);
        playGameAp.getChildren().add(rocket);
        rocket.setVisible(false);
        timer10.setAxe(axe);
        timer10.setRocket(rocket);
        mytime= new MyTimer();
       
       
        
        
        // mytimer7 = new MyTimer7();
        alltimer = new AllTimer();

        timer10.moveDown();
        timer10.setWill(will);
        timer10.setOrcs(Orcs);
        timer10.setOrcList(list);
        alltimer.start();
        
        // Rocket=new ArrayList<ImageView>();
        // timera=new ArrayList<MyTimer5>();

        // a2=1;

    }
    @FXML
    void pause(MouseEvent event) throws Exception{
        App.serialize();
        root = FXMLLoader.load(getClass().getResource("SavedGames.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1100, 600);
        stage.setScene(scene);
        stage.show();
    }
    
    
    public AnchorPane getAnchorPane(){
        return this.playGameAp;
    }

    public void increaseProgress(){

        if(progress<1){

            progress+=0.01;
            db.setProgress(progress);
            myProgressBar.setProgress(progress);
            stepsLabel.setText(Integer.toString(steps));
            //persLabel.setText(Integer.toString(steps)+"%");

        }
    }
    void setCoins(ImageView check){

        int random = (int)Math.floor(Math.random()*(6-1+1)+1);
        if(random==3 || random==4)
       { for(int i =0, j=0 ; i<3 ; i++,j+=50){
            ImageView im2 = factory.getCoin(check.getX()+j, check.getY()-100);
            im2.setX(check.getX()+j);
            im2.setY(check.getY()-100);
            Coin.add(im2);
            playGameAp.getChildren().add(im2);
            
        }}

    }
    void setTNT(ImageView check){

        int random = (int)Math.floor(Math.random()*(8-1+1)+1);
        if(random==3 || random==4)
       { 
        System.out.println("TNT");
        ImageView im=factory.getTNT(check.getX()+50, check.getY());
        im.setX(check.getX()+60);
        im.setY(check.getY());
        im.setY(im.getY()-im.getFitHeight());
        TNT.add(im);
        playGameAp.getChildren().add(TNT.get(TNT.size()-1));
            
        }

    }

    void setChest(ImageView check){

        int random = (int)Math.floor(Math.random()*(6-1+1)+1);
        if(random == 3 || random == 4)
        {
            ImageView im=factory.getChest(check.getX()+10, check.getY());
            im.setY(im.getY()-im.getFitHeight());
            chests.add(im);
            playGameAp.getChildren().add(chests.get(chests.size()-1));
        }
        flag1=true;
       
    }
    void setOrc(ImageView check){

        int random = (int)Math.floor(Math.random()*(9-1+1)+1);
        if(random == 3 || random == 4)
        {
            ImageView im=factory.getOrc(check.getX()+100, check.getY());
            im.setY(im.getY()-im.getFitHeight());
            Orcs.add(im);
            playGameAp.getChildren().add(Orcs.get(Orcs.size()-1));
        }
        flag2=true;

    }
    
    void changeScene()throws Exception{

        alltimer.stop();
        App.serialize();
        root = FXMLLoader.load(getClass().getResource("GameOver.fxml"));
        Stage stage = (Stage)playGameAp.getScene().getWindow();
        stage.setScene(new Scene(root, 1100, 600));
        stage.show();

    }

    void changeScene2()throws Exception{

        App.dList.DeletelastGame(App.currentUser);
        App.serialize();
        
        root = FXMLLoader.load(getClass().getResource("BossPlay.fxml"));
        Stage stage = (Stage)playGameAp.getScene().getWindow();
        stage.setScene(new Scene(root, 1100, 600));
        stage.show();

    }

    @FXML
    void moveFrwd(MouseEvent event) throws Exception{
        increaseProgress();
        steps+=1;
        System.out.println(steps);

        if(steps>=100){
            alltimer.stop();
            changeScene2();
        }

        db.setSteps(steps);
        flag=0;
        t = new Timeline(
                new KeyFrame(
                        javafx.util.Duration.millis(1),
                        ae -> {
                            // if(a2==1){
                            //     mytime2.stop();
                            // }
                            // if(a3==1){
                            //     mytime3.stop();
                            // }
                            mytime.start();
                            
                        }
                )
        );
        t.play();
    }
    
    
    
    
    private class MyTimer extends AnimationTimer{
        private long prevTime = 0;
        @Override
        public void handle(long now) {
            long diff = now - prevTime;
            flag1=false;
            flag2=false;
            
            if(diff>1e5){

            if(rocketFlag==1){
                
                timer10.RocketFunc();
            }
            else if(AxeFlag==1){
                axe.setX(will.getX());
                axe.setY(will.getY());
                timer10.AxeFunc();
            }

            for(int i = 0 ; i<5 ; i++){
                c = list.get(i);
                c.setX(c.getX()-100);
                  
            }
            for(int i=0;i<chests.size();i++){
                ImageView c1=chests.get(i);
                c1.setX(c1.getX()-100);
            }
            for(int i=0;i<Orcs.size();i++){
                ImageView c1=Orcs.get(i);
                c1.setX(c1.getX()-100);
            }
            for(int i=0;i<TNT.size();i++){
                ImageView c1=TNT.get(i);
                c1.setX(c1.getX()-100);
            }
            for(int i=0;i<Coin.size();i++){
                ImageView c1=Coin.get(i);
                c1.setX(c1.getX()-100);
            }
            ImageView img=  list.get(0);
            if(img.getX()+img.getFitWidth()-50<0){
            
                playGameAp.getChildren().remove(img);
                list.remove(0);
                img = list.get(list.size()-1);
                int x= (int)img.getX()+(int)img.getFitWidth()+100;
                img = factory.getImgage(x, 390);
                list.add(img);
                playGameAp.getChildren().add(img);
                ImageView img2;
                if(chests.size()>0)
                {
                    img2 = chests.get(0);
                if(img2.getX()+img2.getFitWidth()<0){
                    playGameAp.getChildren().remove(chests.get(0));
                    chests.remove(0);
                }
            }
            if(Orcs.size()>0)
                {
                    img2 = Orcs.get(0);
                if(img2.getX()+img2.getFitWidth()<0){
                    playGameAp.getChildren().remove(Orcs.get(0));
                    Orcs.remove(0);
                }
            }
            if(TNT.size()>0)
                {
                    img2 = TNT.get(0);
                if(img2.getX()+img2.getFitWidth()<0){
                    playGameAp.getChildren().remove(TNT.get(0));
                    TNT.remove(0);
                }
            }
            if(Coin.size()>0)
                {
                    img2 = Coin.get(0);
                if(img2.getX()+img2.getFitWidth()<0){
                    playGameAp.getChildren().remove(Coin.get(0));
                    Coin.remove(0);
                }
            }
                
                setCoins(img);
                setChest(img);
                setOrc(img);
                
                setTNT(img);
                
            }
        }
        // for(int i=0;i<Coin.size();i++)
        //     {
        //     if(col.detectCollisionCoin(will,Coin.get(i))){
        //         // will.setY(will.getY()-150);
        //         timer10.setCoin(Coin.get(i));
        //         timer10.startCoinHandler();
        //     }
        // }
            mytime.stop();
            // if(a2==1){
            //     mytime2.start();
            // }
            // else if(a3==1){
            //     mytime3.start();
            // }
        }
        }

        
        private class AllTimer extends AnimationTimer{
            // private long prevTimeA = 0;
            @Override
            public void handle(long now) {
                // long diff = now - prevTimeA;
                
                    // prevTimeA = now ;

                    if(will.getY()>560){
                        try
                        {   
                            System.out.println("Game Over");
                            changeScene();
                            alltimer.stop();
                        }
                        catch(Exception e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }

                    for(int i=0;i<Orcs.size();i++)
                    {
                        if((col.detectCollisionOne(axe,Orcs.get(i)) && Orcs.get(i).getImage()!=timer10.getSmashedOrc())||(col.looseCollision(rocket,Orcs.get(i)) && Orcs.get(i).getImage()!=timer10.getSmashedOrc())){
                            try
                            {   
                                System.out.println("Alola Rocky");
                                timer10.setOrc(Orcs.get(i));
                                timer10.setImages(Orcs.get(i),imGen.getSmashedOrc());
                                timer10.fall();
                            }
                            catch(Exception e)
                            {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    for(int i=0;i<Coin.size();i++){
                        
                        if(col.detectCollisionOne(will,Coin.get(i))){
                            timer10.setCoin(Coin.get(i));
                            timer10.startCoinHandler();
                        }
                    }
                    for(int i=0;i<TNT.size();i++){
                        if(col.detectCollisionOne(will,TNT.get(i))){
                            timer10.setTNT(TNT.get(i));
                            timer10.setWill(will);
                            timer10.blast();
                        }
                    }
                    for(int i=0;i<chests.size();i++){
                        // int tag=1;
                        // if(!col.detectCollisionOne(will,chests.get(i))){
                        //     tag=1;
                        //     System.out.println("Alola2u"+" "+tag);
                        // }
                        if(col.detectCollisionOne(will,chests.get(i)) && chests.get(i).getImage()!=timer10.getOpenChest()){
                            // tag=2;
                            // System.out.println("Alola"+" "+tag);
                            timer10.setImages(chests.get(i),imGen.getOpenChest() );
                            // timer10.setChest(chests.get(i));
                            timer10.openChest();
                            double ran = Math.random();
                            // mytime4.stop();
                            // mytimer6.stop();
                            if(ran>=0.5){
                                rocketFlag=1;
                                AxeFlag =0;
                                // currWeapon=rocket;
                                // mytimer6.start();
                                System.out.println("Rocket");
                            }
                            else {
                                // mytime4.start();
                                // currWeapon=axe;
                                AxeFlag=1;
                                rocketFlag=0;
                                System.out.println("Axe");
                            }
                        }
                    }
                    for(int i=0;i<Orcs.size();i++){
                        // timer10.setOrc(Orcs.get(i));
                        timer10.setOrcList(list);
                        // timer10.down();
                        if(col.looseCollision(will, Orcs.get(i))){
                            timer10.setOrc(Orcs.get(i));
                            timer10.pushOrc();
                            // if(!col.detectCollision2(list.get(i), Orcs.get(i))){
                            //     timer10.setOrc(Orcs.get(i));
                            //     timer10.fall();
                            // }
                        }
                        
                        
                        
                        // if(col.detectCollisionOrcLose(will,Orcs.get(i))){
                        //     timer10.setWill(will);
                        //     timer10.setImage(Orcs.get(i),imGen.getSmashedOrc());
                        //     timer10.startSmashHandler();
                        // }
                        
                    }

            }

        }

}
    
  
    

