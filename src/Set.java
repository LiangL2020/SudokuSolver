import java.util.ArrayList;
import java.util.HashMap;

public class Set {

    private Unit[] units;
    private String name;
    private HashMap<Integer, ArrayList<Unit>> optionsList;
    public Set(Unit[] units, String name){
        this.units = units;
        this.name = name;
        optionsList = new HashMap<Integer, ArrayList<Unit>>();
        for (int i = 1; i < 10; i++) {
            optionsList.put(i, new ArrayList<Unit>());
            for(Unit unit : units){
                optionsList.get(i).add(unit);
                unit.getSets().put(name, this);
            }
        }
    }

    public Unit[] getUnits() {
        return units;
    }

    public String getName() {
        return name;
    }
}
