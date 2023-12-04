public class Swordman extends RPGcharacter {
    Swordman(String name) {
        super(name);
        jobType = "Swordman";
        strength = strengthBase = 1.8;
        maxRunSpeed = runSpeedBase = runSpeed = 1;
        intelligence = intelligenceBase = 0.8;
        damStat = strength*50;
        defStat = strength*25;
    }
}

