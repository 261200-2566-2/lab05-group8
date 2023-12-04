interface accInterface{
    String getName();
    int getLv();
    String getWearingType();
    String getJobtype();
    void getDescription();
    double getDefstat();
    double getDamstat();
    double getWeight();
}
public class accessory implements accInterface{
    protected String wearingType;
    protected String name;
    protected String jobType = "noJobType";
    protected double weight =  0.5;
    protected double damStatBase = 0;
    protected double defStatBase = 0;
    protected int lv=0;
    protected accessory(String name,String wearingType,String actionType,double stat){
        this.name = name;
        this.wearingType = wearingType;
        if(actionType.equals("attack")) damStatBase = stat;
        if(actionType.equals("defend")) defStatBase = stat;
    }
    accessory(String type){
        this("",type,"",0);
    }
    @Override
    public String getWearingType(){
        return wearingType;
    }

    @Override
    public String getJobtype() {
        return jobType;
    }

    @Override
    public void getDescription() {
        System.out.println("/////////////////////////////");
        System.out.println("        Name : "+name);
        System.out.println("          Lv : "+lv);
        System.out.println(" wearingType : "+wearingType);
        System.out.println("     jobType : "+getJobtype());
        System.out.println("      weight : "+weight);
        System.out.println("     defStat : "+getDefstat());
        System.out.println("     damStat : "+getDamstat());
        System.out.println("/////////////////////////////");
    }

    @Override
    public double getDefstat() {
        return defStatBase*(1+0.05*this.lv);
    }

    @Override
    public double getDamstat() {
        return damStatBase*(1+0.1*this.lv);
    }

    void lvUp(RPGcharacter p){ //character who use
        lv++;
        p.updateStat();//update character's status
    }
    @Override
    public double getWeight(){
        return this.weight;
    }
    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getLv(){
        return lv;
    }
    boolean wearable(RPGcharacter r){
        return true;
    }
}
