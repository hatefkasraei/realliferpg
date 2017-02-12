package swagteam6.realliferpg;

/**
 * Created by fluff on 11-Feb-17.
 * Project RealLifeRPG
 */

public class Engineer extends mainClasses{

    private final double HP = 12;

    public Engineer(){
        super(12, 6, 6, 1, 2, 3);
    }

    public void resetHP(){
        setHealth(HP);
    }
}
