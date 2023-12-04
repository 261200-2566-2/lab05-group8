public class Wizard extends RPGcharacter {
    Wizard(String name) {
        super(name);
        jobType = "Wizard";
        strength = strengthBase = 0.8;
        maxRunSpeed = runSpeedBase = runSpeed = 1;
        intelligence = intelligenceBase = 1.8;
        damStat = intelligence * 50;
        defStat = intelligence * 25;
    }
}
