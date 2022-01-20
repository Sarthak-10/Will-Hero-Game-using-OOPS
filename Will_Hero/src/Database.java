import java.io.Serializable;

public class Database implements Serializable {
    
    // private static final long serialVersionUID = -8998732895456226514L;

    private int steps;
    private int notes;
    private double progress;
    private String theme;
    private boolean resurrect;
    private int axe;
    private int rocket;

    public Database() {

        this.steps = 0;
        this.notes = 0;
        this.progress=0;
        this.resurrect = true;
        this.axe = 0;
        this.rocket = 0;

    }

    int getSteps() {
        return steps;
    }

    int getCoins(){
        return notes;
    }

    double getProgress(){
        return progress;
    }

    void setSteps(int steps) {
        this.steps = steps;
    }

    void setCoins(int notes) {
        this.notes = notes;
    }

    void setProgress(Double progress) {
        this.progress = progress;
    }

    void setTheme(String t){
        this.theme = t;
    }
    
    String getTheme(){
        return this.theme;
    }
    void setResurrect(boolean v){
        this.resurrect = v;
    }
    boolean canRessurect(){
        return this.resurrect;
    }

    void setAxe(int v){
        this.axe = v;
    }

    void setRocket(int v){
        this.rocket = v;
    }

    int getAxe(){
        return this.axe;
    }

    int getRocket(){
        return this.rocket;
    }

}
