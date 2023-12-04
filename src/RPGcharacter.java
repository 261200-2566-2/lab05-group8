import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

interface character{
    String getName();
    String getJobType();
    double getHp();
    double getMaxHp();
    double getMana();
    int getLv();
    double getExperience();
    double getDamage();
    double getDefence();
    void attack(RPGcharacter e);
    void equip(accessory acc);
    double getRunSpeed();
    void removeAcc(String where);
    double getIntelligence();
    double getStrength();
}
public class RPGcharacter implements character{
    Scanner s = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#.##");
    protected int lv = 0; //starter Lv
    protected double hp = 100; // 100 + 10*0
    protected double maxHp = 100; // 100 + 10*0
    protected double mp = 50; //mana 50 + 2*0
    protected double strength;
    protected double strengthBase;
    protected double intelligence;
    protected double intelligenceBase;
    protected double exp = 0;
    protected String name;
    protected String jobType = "jobless";
    protected  double runSpeedBase;
    protected double maxRunSpeed;
    protected double runSpeed;
    protected accessory lh = new accessory("nothing");
    protected accessory rh = new accessory("nothing");
    protected accessory head = new accessory("nothing");
    protected accessory body = new accessory("nothing");
    protected double damStat = 0;
    protected double defStat = 0;
    protected ArrayList<Item> bag = new ArrayList<>();
    protected int bagcap = 10;
    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public String getJobType() {
        return this.jobType;
    }

    @Override
    public double getHp() {
        return this.hp;
    }
    @Override
    public double getMaxHp() {
        return this.maxHp;
    }

    @Override
    public double getMana() {
        return this.mp;
    }

    @Override
    public int getLv() {
        return this.lv;
    }

    @Override
    public double getExperience() {
        return this.exp;
    }

    @Override
    public double getDamage() {
        return this.damStat;
    }

    @Override
    public double getDefence() {
        return this.defStat;
    }

    @Override
    public void attack(RPGcharacter e) {
        if(e.getDefence() >= this.damStat) System.out.println(e.getName()+" can be defended.");
        else {
            double atk = damStat-e.getDefence();
            System.out.println(name + " attack " + e.name + "(hp -"+atk+" )");
            e.beAttacked(atk);
            exp += atk * 0.1;
            checkLevelUp();
        }
    }

    protected void receivedItem(String itemName){
        Item item = new Item(itemName);
        if(bagcap > bag.size()) {
            bag.add(item);
        }else{
            System.out.println("Your bag is full.");
        }
    }

    protected void useitem(){
        for (int i=0;i<bag.size();i++){
            System.out.println(i+1+".) "+bag.get(i).name);
        }
        System.out.println("Which item you want to use? (number) : ");
        Item item = bag.remove(s.nextInt()-1);
        if(item.name.equals("potion")) {
            if(hp+20 > maxHp) hp = maxHp;
            else hp+=20;
            System.out.println(name +"'s Hp+20 now hp = " + hp);
        }
        if(item.name.equals("expCard")) {
            exp += 20;
            System.out.println(name +"'s exp+20 now exp = " + exp);
        }
    }
    private void beAttacked(double atk){
        hp -= atk;
        if(hp<=0) System.out.println(name+" dies.");
    }

    private void checkLevelUp() {
        if(exp >= 10+Math.pow(2,lv)){
            LvUp();
            System.out.println(name+" level up!!! now lv = "+lv);
        }
    }

    @Override
    public void equip(accessory acc) {
        if(!acc.wearable(this)){
            System.out.println(name + " can not use this accessory.");
            return;
        }
        if(acc.getWearingType().equals("head") && head.getWearingType().equals("nothing")){
            head = acc;
            setStat(head);
        } else if(acc.getWearingType().equals("head") && !head.getWearingType().equals("nothing")){
            System.out.println("head is full.");
        } else if(acc.getWearingType().equals("body") && body.getWearingType().equals("nothing")){
            body = acc;
            setStat(body);
        } else if(acc.getWearingType().equals("body") && !body.getWearingType().equals("nothing")){
            System.out.println("body is full.");
        } else if(acc.getWearingType().equals("weapon")){
            System.out.println("Which hand that you want to hold it? (left/right) : ");
            equipWeapon(acc,s.nextLine());
        }
    }

    @Override
    public double getRunSpeed() {
        return this.runSpeed;
    }

    @Override
    public void removeAcc(String where) {
        if(where.equals("left hand")){
            lh = new accessory("nothing");
        }
        if(where.equals("right hand")){
            rh = new accessory("nothing");
        }
        if(where.equals("head")){
            head = new accessory("nothing");
        }
        if(where.equals("body")){
            body = new accessory("nothing");
        }
        updateStat();
    }

    @Override
    public double getIntelligence() {
        return this.intelligence;
    }

    @Override
    public double getStrength() {
        return this.strength;
    }

    protected RPGcharacter(String name){
        this.name = name;
    }
    private void LvUp(){
        lv++;
        bagcap++;
        maxHp = 100 + 10*lv; //charLv
        mp = 50 +2*lv; //charLv
        maxRunSpeed = runSpeedBase+runSpeedBase*(0.1+0.03*lv);
        strength = strengthBase+strengthBase*(0.1+0.03*lv);
        intelligence = intelligenceBase+intelligenceBase*(0.1+0.03*lv);
        updateStat();
    }
    void equipWeapon(accessory eq,String hand){
        if( hand.equals("left" ) && lh.getWearingType().equals("nothing")){
            lh = eq;
            setStat(eq);
        } else if(hand.equals("left" ) && !lh.getWearingType().equals("nothing")){
            System.out.println("Left hand is full.");
        } else if( hand.equals("right" ) && rh.getWearingType().equals("nothing")){
            rh = eq;
            setStat(eq);
        } else if(hand.equals("right" ) && !rh.getWearingType().equals("nothing")){
            System.out.println("Right hand is full.");
        }
    }

    protected void setStat(accessory w){
        if(w.wearingType.equals("nothing")) return;
        runSpeed -=  runSpeedBase*(0.1+w.getWeight()*w.getLv());
        damStat += w.getDamstat();
        defStat += w.getDefstat();
    }

    protected void updateStat(){
        if(jobType.equals("Swordman") || jobType.equals("Assasin")){
            damStat = strength*50;
            defStat = strength*25;
        }else if(jobType.equals("Wizard") ){
            damStat = intelligence*50;
            defStat = intelligence*25;
        }else{
            damStat = 0;
            defStat = 0;
        }
        runSpeed = maxRunSpeed;
        setStat(lh); //left hand
        setStat(rh); //right hand
        setStat(head);
        setStat(body);
    }

    protected void statusWindow(){
        System.out.println("_____________________________");
        System.out.println("        Name : "+getName());
        System.out.println("          Lv : "+getLv());
        System.out.println("         Job : "+getJobType());
        System.out.println("          HP : "+df.format(getHp())+"/"+df.format(getMaxHp()));
        System.out.println("        Mana : "+df.format(getMana()));
        System.out.println("    Strength : "+df.format(getStrength()));
        System.out.println("intelligence : "+df.format(getIntelligence()));
        System.out.println("    runSpeed : "+df.format(getRunSpeed()));
        System.out.println("     damStat : "+df.format(getDamage()));
        System.out.println("     defStat : "+df.format(getDefence()));
        System.out.println("    _________________      ");
        System.out.print("    leftHand : ");
        if(!lh.getWearingType().equals("nothing")) System.out.println(lh.getName()+" lv."+lh.getLv()+"("+getJobType()+")");
        else System.out.println("nothing");
        System.out.print("   rightHand : ");
        if(!rh.getWearingType().equals("nothing")) System.out.println(rh.getName()+" lv."+rh.getLv()+"("+getJobType()+")");
        else System.out.println("nothing");
        System.out.print("        Head : ");
        if(!head.getWearingType().equals("nothing")) System.out.println(head.getName()+" lv."+head.getLv()+"("+getJobType()+")");
        else System.out.println("nothing");
        System.out.print("        Body : ");
        if(!body.getWearingType().equals("nothing")) System.out.println(body.getName()+" lv."+body.getLv()+"("+getJobType()+")");
        else System.out.println("nothing");
        System.out.println("_____________________________");
        System.out.println(" ");
    }
}

