import java.util.List;

public class Pokemon {
    private String name;
    private String type1;
    private String type2;
    private int total;
    private int hp;
    private int attack;
    private int defense;
    private int spAtk;
    private int spDef;
    private int speed;
    private List<Integer> attacks;





    public Pokemon(String name, String type1, String type2, int total, int hp, int attack, int defense, int spAtk, int spDef, int speed, List<Integer> attacks) {
        this.name = name;
        this.hp = hp;
        this.attacks = attacks;
        this.type1 = type1;
        this.type2 = type2;
        this.total = total;
        this.defense = defense;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.attack = attack;
        this.speed = speed;
    }

    public String getName(){
        return name;
    }
    public void  setName(String name) {
        this.name = name;
    }
    public int getHp(){
        return hp;
    }
    public void setHp(int hp){
        this.hp = hp;
    }

    public List<Integer> getAttacks(){
        return attacks;
    }

    public void setAttacks(List<Integer> attacks){
        this.attacks = attacks;
    }
    public String getType1(){
        return type1;
    }
    public  void setType1(String type1){
        this.type1 = type1;
    }
    public String getType2(){
        return type2;
    }
    public  void setType2(String type2){
        this.type2 = type2;
    }
    public int getTotal(){
        return total;
    }
    public void setTotal(int total){
        this.total = total;
    }
    public int getDefense(){
        return defense;
    }
    public void setDefense(int defense){
        this.defense = defense;
    }

    public int getSpAtk(){
        return spAtk;
    }
    public void setSpAtk(int spAtk){
        this.spAtk = spAtk;
    }
    public int getSpDef(){
        return spDef;
    }
    public void setSpDef(int spDef){
        this.spDef = spDef;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0){
            hp = 0;
        }
    }
}
