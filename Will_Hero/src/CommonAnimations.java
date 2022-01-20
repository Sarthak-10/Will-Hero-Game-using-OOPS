// import javafx.scene.image.ImageView;
// import javafx.animation.ScaleTransition;
// import javafx.animation.TranslateTransition;
// import javafx.scene.image.Image;

// public class CommonAnimations{

//     Image smashedWill = new Image(getClass().getResourceAsStream("pic/Smashed_Will.png"));
//     Image Will = new Image(getClass().getResourceAsStream("pic/Will.png"));
//     Image openChest = new Image(getClass().getResourceAsStream("pic/Open_Chest.png"));
//     Image stars = new Image(getClass().getResourceAsStream("pic/stars.png"));
//     Image blasted_tnt = new Image(getClass().getResourceAsStream("pic/blasted_tnt.png"));

//     public void changeImage(ImageView first, Image second) {
//         first.setImage(second);
//     }
//     public void smashedWillAnimation(ImageView will,TranslateTransition tr,ScaleTransition sc){
//         star.setLayoutX(will.getLayoutX());
//         star.setLayoutY(will.getLayoutY() - 20);
//         changeImage(star, stars);
//         CAnimations.rotate(star, 'y', 360.0, 500.0, 0);
//         will.setLayoutY(isl2.getLayoutY() - 25);
//         changeImage(will, smashedWill);
//         tr.stop();
//         sc.stop();
//     }
// }