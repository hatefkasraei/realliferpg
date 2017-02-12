package swagteam6.realliferpg;

/**
 * Created by fluff on 11-Feb-17.
 * Project RealLifeRPG
 */

public class mainClasses {

    private double health, stamina, intelligence, strength, agility, luck, damage;

    public mainClasses(double hp, double mana, double intel, double str,
                       double speed, double lck){
        health = hp;
        stamina = mana;
        intelligence = intel;
        strength = str;
        agility = speed;
        luck = lck;
        damage = str + (intel/2);
    }

    public mainClasses(){
        this(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    }

    public void setHealth(double hp){
        health = hp;
    }
    public double getHealth(){
        return health;
    }

    public void setStamina(double mana){
        stamina = mana;
    }
    public double getStamina(){
        return stamina;
    }

    public void setIntelligence(double intel){
        intelligence = intel;
    }
    public double getIntelligence(){
        return intelligence;
    }

    public void setStrength(double str){
        strength = str;
    }
    public double getStrength(){
        return strength;
    }

    public void setAgility(double speed){
        agility = speed;
    }
    public double getAgility(){
        return agility;
    }

    public void setLuck(double lck){
        luck = lck;
    }
    public double getLuck(){
        return luck;
    }
}
