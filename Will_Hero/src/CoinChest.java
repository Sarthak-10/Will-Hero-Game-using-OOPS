import javafx.scene.image.ImageView;

public class CoinChest {

    private ImageView coin ;

    public CoinChest(){
        this.coin = null;
    }

    void generateCoin(){

        this.coin = new ImageView("pic/Coin.png");
    }

    public ImageView getCoin(double x, double y){

        generateCoin();
        coin.setFitHeight(60);
        coin.setFitWidth(50);
        coin.setX(x);
        coin.setX(y);
        return coin;

    }

}
