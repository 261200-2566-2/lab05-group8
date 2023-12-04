public class AssasinAcc extends accessory {
    AssasinAcc(String name, String wearingType, String actionType, double stat) {
        super(name, wearingType, actionType, stat);
        jobType = "Assasin";
        weight = 0.3;
    }

    @Override
    boolean wearable(RPGcharacter r) {
        return r.maxRunSpeed >= lv+1;
    }
}
