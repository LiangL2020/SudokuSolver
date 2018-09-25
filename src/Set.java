import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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

        for (Unit u: units) {
            if(u.isPointed()) {
                Set row = u.getSets().get("row");
                for(Unit unit: row.getUnits()) {
                    if((unit.isPointed()) && (equalLists(unit.posval, u.posval)) && (unit.getSets().get("box") == u.getSets().get("box"))) {
                        for (Unit unit1: row.getUnits()) {
                            if(unit1 != unit && unit1 != u) {
                                if(unit1.posval != null && unit1.posval.size() > 1 && !unit1.posval.contains(u.posval.get(0)))
                                    removeEntryFromList(unit1.posval, u.posval.get(0));
                                if(unit1.posval != null && unit1.posval.size() > 1 && !unit1.posval.contains(u.posval.get(1)))
                                    removeEntryFromList(unit1.posval, u.posval.get(1));
                            }
                        }
                    }
                }
            }

                Set col = u.getSets().get("col");
                for(Unit unit: col.getUnits()) {
                    if((unit.isPointed()) && (equalLists(unit.posval, u.posval)) && (unit.getSets().get("box") == u.getSets().get("box"))) {
                        for (Unit unit1: col.getUnits()) {
                            if(unit1 != unit && unit1 != u) {
                                if(unit1.posval != null && unit1.posval.size() > 1 && !unit1.posval.contains(u.posval.get(0)))
                                    removeEntryFromList(unit1.posval, u.posval.get(0));
                                if(unit1.posval != null && unit1.posval.size() > 1 && !unit1.posval.contains(u.posval.get(1)))
                                    removeEntryFromList(unit1.posval, u.posval.get(1));
                            }
                        }
                    }
                }

        }
    }

    public Unit[] getUnits() {
        return units;
    }

    public String getName() {
        return name;
    }

    public void removeEntryFromList(ArrayList<String> list, String s) {
        int index = 999;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(s)) {
                index = i;
            }
        }
        if(index != 999) {
            list.remove(index);
        }
    }

    //returns if two lists have the same elements disregarding order
    public  boolean equalLists(List<String> one, List<String> two){
        if (one == null && two == null){
            return true;
        }

        if((one == null && two != null)
                || one != null && two == null
                || one.size() != two.size()){
            return false;
        }

        one = new ArrayList<String>(one);
        two = new ArrayList<String>(two);

        Collections.sort(one);
        Collections.sort(two);
        return one.equals(two);
    }
}
