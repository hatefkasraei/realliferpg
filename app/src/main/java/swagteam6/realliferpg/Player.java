package swagteam6.realliferpg;

/**
 * Created by fluff on 11-Feb-17.
 * Project RealLifeRPG
 */

public class Player{

    private String name;
    private int experience;
    private mainClasses job;

    public Player(){
        this("", 0.0, null);
    }

    public Player(String nomen, int exp, mainClasses job){
        name = nomen;
        experience = exp;
        this.job = job;
    }

    public void setName(String nomen){
        name = nomen;
    }
    public String getName(){
        return name;
    }

    public void setExperience(int exp){
        experience = exp;
    }
    public int getExperience(){
        return experience;
    }

    public void setJob(mainClasses job){
        this.job = job;
    }
    public mainClasses getJob(){
        return job;
    }

}
