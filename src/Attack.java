public class Attack {
    private String name;
    private String effect;
    private String type;
    private String kind;
    private int power;
    private String accuracy;
    private int pp;

    public Attack(String name,  String effect,  String type, String kind, int power, String accuracy, int pp){
        this.name = name;
        this.power = power;
        this.accuracy= accuracy;
        this.type = type;
        this.kind = kind;
        this.pp = pp;
        this.effect = effect;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEffect(){
        return effect;
    }
    public void setEffect(String effect){
        this.effect = effect;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    public String getKind(){
        return kind;
    }
    public void setKind(String kind){
        this.kind = kind;
    }
    public int getPower(){
        return power;
    }
    public void setPower(int power){
        this.power = power;
    }
    public String  getAccuracy(){
        return accuracy;
    }
    public void setAccuracy(String accuracy){
        this.accuracy = accuracy;
    }
    public int getPp(){
        return pp;
    }
    public void setPp(int pp){
        this.pp = pp;
    }
}
