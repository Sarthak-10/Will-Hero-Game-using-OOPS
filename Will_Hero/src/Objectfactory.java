import javafx.scene.image.ImageView;

public class Objectfactory {
    
    private ImageView img = null;
    private int prev=0;
    private int min,max;
    private ImageView coin = null;
    private ImageView chest = null;
    private ImageView orc = null;
    private ImageView tnt = null;
    public ImageView createImage(int x, int y, int h,int w,String path){
        img = new ImageView(path);
        img.setX(x);
        img.setY(y);
        img.setFitHeight(h);
        img.setFitWidth(w);
        return img;
    }

    public void generateImage(int n){

        switch (n) {

            // case 1: img = new ImageView("pic/greenIsland1.png");
            //         img.setFitHeight(182);
            //         img.setFitWidth(175);
            //         img.setY(329);
            //     break;
            case 1: img = new ImageView("pic/greenIsland2.png");
                    img.setFitHeight(152);
                    img.setFitWidth(205);
                    img.setY(364);    
                break;
            case 2: img = new ImageView("pic/greenIsland3.png");
                    img.setFitHeight(121);
                    img.setFitWidth(263);
                    img.setY(450);
                break;
            // case 4: img = new ImageView("pic/Island-7.png");
            //         img.setFitHeight(212);
            //         img.setFitWidth(143);
            //         img.setY(283);
            //     break;
            // case 5: img = new ImageView("pic/greenIsland7.png");
            //         img.setFitHeight(238);
            //         img.setFitWidth(204);
            //         img.setY(265);
            //     break;
            case 3: img = new ImageView("pic/greenIsland6.png");
                    img.setFitHeight(187);
                    img.setFitWidth(193);
                    img.setY(300);
                break;
            // case 7: img = new ImageView("pic/Island-8.png");
            //         img.setFitHeight(134);
            //         img.setFitWidth(199);
            //         img.setY(364);
            //     break;
            // case 8: img = new ImageView("pic/redIsalnd2.png");
            //         img.setFitHeight(193);
            //         img.setFitWidth(200);
            //         img.setY(364);
            //     break;
            // case 9: img = new ImageView("pic/redIsalnd3.png");
            //         img.setFitHeight(204);
            //         img.setFitWidth(238);
            //         img.setY(364);
            //     break;
            default:
                break;

        }

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
    public ImageView getOrc(double x, double y){

        int n = (int)Math.floor(Math.random()*(2-1+1)+1);
        generateOrc(n);
        orc.setX(x);
        orc.setY(y);
        return orc;
    }
    public ImageView getTNT(double x, double y){

        tnt = new ImageView("pic/TNT.png");
        tnt.setFitHeight(60);
        tnt.setFitWidth(50);
        tnt.setX(x);
        tnt.setX(y);

        return tnt;
    }
    public ImageView getBoss(double x,double y){
        ImageView boss = new ImageView("pic/Boss.png");
        boss.setFitHeight(195);
        boss.setFitWidth(180);
        boss.setX(x);
        boss.setY(y);
        return boss;
    }
    public ImageView getCoin(double x, double y){

        coin = new ImageView("pic/Coin.png");
        coin.setFitHeight(30);
        coin.setFitWidth(30);
        coin.setX(x);
        coin.setX(y);

        return coin;
    }

    public ImageView getImgage(int x, int y){
        int n;
        min =1; max =3;

        do {
            n = (int)Math.floor(Math.random()*(max-min+1)+min);

        } while (prev==n);
        prev = n;
        generateImage(n);
        img.setX(x);
        img.setY(y);
        //img.setPreserveRatio(true);

        return img;
    }
}
