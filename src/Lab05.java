public class Lab05 {
    public static void main(String[] args) {
        Swordman m = new Swordman("Mind");
        Wizard f = new Wizard("Film");
        Assasin un = new Assasin("Unknow");
        SwordmanAcc rs = new SwordmanAcc("redSword","weapon","attack",50);
        SwordmanAcc rh = new SwordmanAcc("redHat","head","defend",50);
        AssasinAcc gh = new AssasinAcc("greenHat","head","defend",150);
        f.receivedItem("potion");
        f.receivedItem("potion");
        f.receivedItem("expCard");
        m.statusWindow();
        f.statusWindow();
        m.statusWindow();
        un.statusWindow();
        un.equip(gh);
        f.equip(rh);
        f.statusWindow();
        System.out.println("Mind exp = "+m.getExperience());
        m.attack(f);
        f.statusWindow();
        System.out.println("Mind exp = "+m.getExperience());
        m.attack(f);
        f.statusWindow();
        f.useitem();
        f.useitem();
        System.out.println("Mind exp = "+m.getExperience());
        m.attack(f);
        System.out.println("Mind exp = "+m.getExperience());
        m.statusWindow();
        f.statusWindow();
        un.statusWindow();
        m.attack(un);
        rs.getDescription();
        rh.getDescription();
        gh.getDescription();
        m.equip(rs);
        m.equip(rh);
        m.statusWindow();
    }
}
