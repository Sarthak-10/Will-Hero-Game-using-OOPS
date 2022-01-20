import javafx.scene.image.Image;

public class ImageGenerator {
    private final Image smashed_will;
    private final Image openChest;
    private final Image blasted_TNT;
    private final Image smashed_orc;
    private final Image smashed_boss;
    public ImageGenerator(){
        smashed_will = new Image(getClass().getResourceAsStream("pic/Smashed_Will.png"));
        openChest = new Image(getClass().getResourceAsStream("pic/Open_Chest.png"));
        blasted_TNT = new Image(getClass().getResourceAsStream("pic/blasted_tnt.png"));
        smashed_orc = new Image(getClass().getResourceAsStream("pic/Smashed_orc.png"));
        smashed_boss = new Image(getClass().getResourceAsStream("pic/Astonished_Boss.png"));
    }
    public Image getSmashedWill(){
        return this.smashed_will;
    }
    public Image getOpenChest(){
        return this.openChest;
    }
    public Image getSmashedOrc(){
        return this.smashed_orc;
    }
    public Image getBlastedTNT(){
        return this.blasted_TNT;
    }
    public Image getSmashedBoss(){
        return this.smashed_boss;
    }
}
