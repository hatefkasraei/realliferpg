package swagteam6.realliferpg;

/**
 * Created by fluff on 11-Feb-17.
 * Project RealLifeRPG
 */

public class Player{

    private String name;
    private int experience, level, expCap;
    private mainClasses job;


    public Player(String nomen, mainClasses job){
        name = nomen;
        experience = 0;
        level = 1;
        expCap = 50;
        this.job = job;
    }

    public Player(){
        this("", null);
    }

    public void setName(String nomen){
        name = nomen;
    }
    public String getName(){
        return name;
    }

    public void setLevel(int lvl){
        level = lvl;
    }
    public int getLevel(){
        return level;
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

    public void takeDamage(double dmg){
        double newHealth = job.getHealth() - dmg;
        job.setHealth(newHealth);
    }

    public void gainExperience(int exp){
        experience += exp;
        if (experience >= expCap){
            level++;
            experience = experience%expCap;
            expCap *= 2;
        }
    }

    public void levelUP(int lvlup){
        if(experience == expCap)
            level++;
    }
}
