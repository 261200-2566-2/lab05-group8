public class Lab05 {
    public static void main(String[] args) {
        Swordman m = new Swordman("Mind");
        Wizard f = new Wizard("Film");
        Assasin un = new Assasin("Unknow");

        SwordmanAcc rs = new SwordmanAcc("redSword","weapon","attack",50);
        SwordmanAcc rh = new SwordmanAcc("redHat","head","defend",50);
        AssasinAcc gh = new AssasinAcc("greenHat","head","defend",150);
        //test receivedItem
        f.receivedItem("potion");
        f.receivedItem("potion");
        f.receivedItem("expCard");
        //status after create character base on their job
        m.statusWindow();
        f.statusWindow();
        un.statusWindow();
        //test equipment
        un.equip(gh);//wearable
        f.equip(rh);//not wearable (not pass requirement)

        System.out.println("Mind exp = "+m.getExperience()); //exp before attack
        m.attack(f); //attack
        f.statusWindow(); //status after be attacked
        System.out.println("Mind exp = "+m.getExperience()); //exp after attack
        m.attack(f); //attack
        f.statusWindow(); //status after be attacked
        f.useitem(); //use item
        f.statusWindow();//hp after use potion or exp after use expCard
        System.out.println("Mind exp = "+m.getExperience());
        m.attack(f);
        System.out.println("Mind exp = "+m.getExperience());
        m.statusWindow(); //after Lv up
        un.statusWindow(); //show that unknow's def more than mind's dam
        m.attack(un);//show defend
        //show accessory description
        rs.getDescription();
        rh.getDescription();
        gh.getDescription();
        //equip many accessory
        m.equip(rs);
        m.equip(rh);
        m.equip(rh);//head is full. can't equip.
        m.statusWindow();
    }
}
