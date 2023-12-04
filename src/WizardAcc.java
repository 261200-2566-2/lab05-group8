public class WizardAcc extends accessory {
    WizardAcc(String name, String wearingType, String actionType, double stat) {
        super(name, wearingType, actionType, stat);
        jobType = "Wizard";
        weight = 0.5;
    }

    @Override
    boolean wearable(RPGcharacter r) {
        return r.intelligence >= lv+1;
    }
}
