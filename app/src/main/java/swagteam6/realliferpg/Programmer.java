package swagteam6.realliferpg;

/**
 * Created by fluff on 11-Feb-17.
 * Project RealLifeRPG
 */

public class Programmer extends mainClasses {

    private final double HP = 10;

    public Programmer(){
        super(10, 6, 6, 3, 3, 2);
    }

    public void resetHP(){
        setHealth(HP);
    }
}
