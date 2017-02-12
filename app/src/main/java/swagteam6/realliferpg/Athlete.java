package swagteam6.realliferpg;

/**
 * Created by fluff on 11-Feb-17.
 * Project RealLifeRPG
 */

public class Athlete extends mainClasses {

    private final double HP = 12;

    public Athlete(){
        super(12, 7, 0, 5, 4, 2);
    }

    public void resetHP(){
        setHealth(HP);
    }
}
