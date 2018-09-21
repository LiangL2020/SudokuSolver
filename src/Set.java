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

    public void update() {
        for (int i = 1; i < 10; i++) {
            ArrayList<Unit> option = optionsList.get(i);
            if(option != null) {
                for (Unit unit : units) {
                    if(unit.getValue().equals(i + "")){
                        optionsList.remove(option);
                    }
                    else if(!unit.hasOption(i + "")){
                        option.remove(unit);
                    }
                }
            }
        }

        for (int i = 1; i < 10; i++) {
            ArrayList<Unit> option = optionsList.get(i);
            if(option != null && option.size() == 1){
                option.get(0).setValue(i + "");
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
