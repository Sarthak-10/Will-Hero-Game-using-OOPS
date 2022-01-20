
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Animmations {


    public static void trasnlate(Node node, char c, double amt, double dur, double del, boolean rev) {

        TranslateTransition translate = new TranslateTransition();

        translate.setNode(node);
        if (c == 'y')
            translate.setByY(amt);
        else if (c == 'x')
            translate.setByX(amt);
        else
            translate.setByZ(amt);

        translate.setDelay(Duration.seconds(del));
        translate.setDuration(Duration.millis(dur));

        if (rev) {
            translate.setAutoReverse(true);
            translate.setCycleCount(TranslateTransition.INDEFINITE);
        }
        translate.play();

    }

    public static void scale(Node node, char c, double amt, double dur, double del) {

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDelay(Duration.millis(del));
        scale.setDuration(Duration.millis(dur));
        scale.setCycleCount(TranslateTransition.INDEFINITE);
        scale.setInterpolator(Interpolator.LINEAR);

        if (c == 'y')
            scale.setByY(amt);
        else if (c == 'x')
            scale.setByX(amt);
        else
            scale.setByZ(amt);

        scale.setAutoReverse(true);
        scale.play();

    }

    public static void fadein(Node node, double fadeval, double time, double delay) {

        FadeTransition fade = new FadeTransition();
        fade.setNode(node);
        fade.setDelay(Duration.seconds(delay));
        fade.setDuration(Duration.seconds(time));
        fade.setFromValue(0);
        fade.setToValue(fadeval);
        fade.play();

    }

    public static void flyup(Node node) {

        TranslateTransition fly = new TranslateTransition();
        fly.setNode(node);
        fly.setByY(-750);
        fly.setDelay(Duration.seconds(3));
        fly.setDuration(Duration.seconds(2));
        fly.setAutoReverse(false);
        fly.play();

    }

    public static void rotate(Node node, double angle) {

        RotateTransition rotate = new RotateTransition();
        rotate.setNode(node);
        rotate.setByAngle(angle);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.setDuration(Duration.millis(500));
        rotate.play();

    }

}
