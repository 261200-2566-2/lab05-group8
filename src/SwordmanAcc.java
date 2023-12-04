public class SwordmanAcc extends accessory{
    SwordmanAcc(String name,String wearingType,String actionType,double stat){
        super(name,wearingType,actionType,stat);
        jobType = "Swordman";
        weight = 0.8;
    }
    @Override
    boolean wearable(RPGcharacter r){
        return r.strength >=lv+1;
    }
}

