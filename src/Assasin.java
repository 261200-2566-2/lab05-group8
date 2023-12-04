public class Assasin extends RPGcharacter {
    Assasin(String name) {
        super(name);
        jobType = "Assasin";
        strength = strengthBase = 0.8;
        maxRunSpeed = runSpeedBase = runSpeed = 1.8;
        intelligence = intelligenceBase = 1;
        damStat = strength * 50;
        defStat = strength * 25;
    }
}

