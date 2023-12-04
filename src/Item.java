interface itemInter{
    String getName();
    String getDescription();
}
public class Item implements itemInter{
    String name;
    Item(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        if(name.equals("potion")) return "using potion to heal character by 20 point(Hp) per bottle.";
        if(name.equals("expCard")) return "using expCard to gain 20 exp.";
        return "nothing here.";
    }
}
