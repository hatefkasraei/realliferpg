package swagteam6.realliferpg;

/**
 * Created by fluff on 11-Feb-17.
 * Project RealLifeRPG
 */

public class mainClasses {

    private int health, stamina, intelligence, strength, agility, luck;

    public mainClasses(int hp, int mana, int intel, int str, int speed, int lck){
        health = hp;
        stamina = mana;
        intelligence = intel;
        strength = str;
        agility = speed;
        luck = lck;
    }

    public mainClasses(){
        this(0, 0, 0, 0, 0, 0);
    }

    public void setHealth(int hp){
        health = hp;
    }
    public int getHealth(){
        return health;
    }

    public void setStamina(int mana){
        stamina = mana;
    }
    public int getStamina(){
        return stamina;
    }

    public void setIntelligence(int intel){
        intelligence = intel;
    }
    public int getIntelligence(){
        return intelligence;
    }

    public void setStrength(int str){
        strength = str;
    }
    public int getStrength(){
        return strength;
    }

    public void setAgility(int speed){
        agility = speed;
    }
    public int getAgility(){
        return agility;
    }

    public void setLuck(int lck){
        luck = lck;
    }
    public int getLuck(){
        return luck;
    }
}
