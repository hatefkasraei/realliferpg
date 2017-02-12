package swagteam6.realliferpg;

/**
 * Created by fluff on 11-Feb-17.
 * Project RealLifeRPG
 */

public class Nurse extends mainClasses{

    private final double HP = 13;

    public Nurse(){
        super(13, 4, 4, 1, 2, 6);
    }

    public void resetHP(){
        setHealth(HP);
    }
}
