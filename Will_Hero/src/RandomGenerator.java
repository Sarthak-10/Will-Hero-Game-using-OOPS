import javafx.scene.image.ImageView;

public class RandomGenerator {
    private ImageView img = null;
    private int prev=0;
    private int min,max;
    public ImageView generateImage(int n,double x,double y,double h,double w){
        String path;
        if(n==1){
            int a;
            a=(int)Math.round(Math.random());
            if(a==1){
                path="pic/Standard_Green_Orc.png";
            }
            else{
                path="pic/Standard_Red_Orc.png";
            }
        }
        else if(n==2){
            int a;
            a=(int)Math.round(Math.random());
            if(a==1){
                path="pic/Weapon_Chest.png";
            }
            else{
                path="pic/pinkchest.png";
            }
        }
        else{
            path="pic/TNT.png";
        }

        img = new ImageView(path);
        img.setX(x);
        img.setY(y);
        img.setFitHeight(h);
        img.setFitWidth(w);
        return img;
    }
    public ImageView getImage(double x,double y,double h,double w){
        int n;
        min =1; max =3;

        do {
            n = (int)Math.floor(Math.random()*(max-min+1)+min);

        } while (prev==n);
        prev = n;
        img = generateImage(n,x,y,h,w);
        return img;
    }
}
