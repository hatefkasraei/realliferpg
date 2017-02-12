package swagteam6.realliferpg;

/**
 * Created by fluff on 11-Feb-17.
 * Project RealLifeRPG
 */

public class CouchPotato extends mainClasses {

    private final double HP = 20;

    public CouchPotato(){
        super(20, 5, 2, 2, 1, 0);
    }

    public void resetHP(){
        setHealth(HP);
    }
}

