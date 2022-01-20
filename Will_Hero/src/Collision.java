import javafx.scene.image.ImageView;

public class Collision{
    public Boolean detectCollisionOne(ImageView first,ImageView second){
        try{
            if ( first.getY()<second.getY()+second.getFitHeight() && first.getX()+first.getFitWidth()>second.getX() && first.getY()+first.getFitHeight()>second.getY() && first.getX()<second.getX()+second.getFitWidth() ) {
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

    public Boolean detectCollisionOrcLose(ImageView first,ImageView second){
        try{
            if ( first.getY()<second.getY()+second.getFitHeight() && first.getX()+first.getFitWidth()>second.getX() ) {
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
    public Boolean detectCollisionWillWin(ImageView first,ImageView second){
        try{
            if ( first.getX()+first.getFitWidth()>second.getX() && first.getX()<second.getX()+second.getFitWidth() ) {
                System.out.println("Win");
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
    public Boolean looseCollision(ImageView first, ImageView second) {
        try{
            if ( first.getX()+first.getFitWidth()>second.getX() && first.getY()<second.getY()+second.getFitHeight() && first.getY()+first.getFitHeight()>second.getY()) {
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
}