import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

public class CAnimations {
    public static FadeTransition fade(ImageView node, double amt1, double amt2, double dur, int d, int p) {

        FadeTransition fade = new FadeTransition();
        fade.setNode(node);
        fade.setDelay(Duration.millis(200));
        fade.setDuration(Duration.millis(dur));
        if (d == 1) {
            fade.setCycleCount(TranslateTransition.INDEFINITE);
        } else {
            fade.setCycleCount(d);
        }
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(amt1);
        fade.setToValue(amt2);
        if (p == 1) {
            fade.play();
        }
        return fade;
    }

    public static ScaleTransition scale(ImageView node, char c, double amt, double dur, int d, int a) {

        ScaleTransition scale = new ScaleTransition();
        scale.setNode(node);
        scale.setDelay(Duration.millis(200));
        scale.setDuration(Duration.millis(dur));
        if (d == 0) {
            scale.setCycleCount(TranslateTransition.INDEFINITE);
        } else {
            scale.setCycleCount(d);
        }
        scale.setInterpolator(Interpolator.LINEAR);
        if (a == 1) {
            scale.setAutoReverse(true);
        } else {
            scale.setAutoReverse(false);
        }
        if (c == 'y')
            scale.setByY(amt);
        else if (c == 'x')
            scale.setByX(amt);
        else
            scale.setByZ(amt);

        scale.play();
        return scale;
    }

    public static TranslateTransition translate(ImageView node, char c, double amt, double dur, int d, int p) {

        TranslateTransition tt = new TranslateTransition();
        tt.setNode(node);
        tt.setDuration(Duration.millis(dur));
        if (d == 1) {
            tt.setCycleCount(TranslateTransition.INDEFINITE);
        }
    
        tt.setAutoReverse(true);
        
        if (c == 'y')
            tt.setByY(amt);
        else if (c == 'x')
            tt.setByX(amt);
        else
            tt.setByZ(amt);
        if (p == 1) {
            tt.play();
        }

        return tt;
    }

    public static RotateTransition rotate(ImageView node, char c, double amt, double dur, int d) {

        RotateTransition rotate = new RotateTransition();
        rotate.setNode(node);
        rotate.setDuration(Duration.millis(dur));
        if (d == 0) {
            rotate.setCycleCount(TranslateTransition.INDEFINITE);
        } else {
            rotate.setCycleCount(d);
        }
        rotate.setByAngle(amt);

        if (c == 'y')
            rotate.setAxis(Rotate.Y_AXIS);
        else if (c == 'x')
            rotate.setAxis(Rotate.X_AXIS);
        else
            rotate.setAxis(Rotate.Z_AXIS);

        rotate.play();
        return rotate;
    }
}
