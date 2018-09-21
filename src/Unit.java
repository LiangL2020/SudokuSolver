import java.util.ArrayList;
import java.util.HashMap;

public class Unit {

    private String value;
    //current value of unit

    ArrayList<String> posval = new ArrayList<String>();
    //possible values of unit
    private HashMap<String, Set> sets;
    public Unit(String value) {
        sets = new HashMap<String, Set>();
        this.value = value;

        for (int i = 0; i < 9; i++) {

            posval.add(String.valueOf(i + 1));

        }

    }

    public void addSet(Set set){
        sets.put(set.getName(), set);
    }

    public void update(String[] row, String[] col, Unit[][] box){
        for(String s: row) {
            if(posval.contains(s))
                posval.remove(s);
        }
        for(String s: col) {
            if(posval.contains(s))
                posval.remove(s);
        }
        for(Unit[] ss: box) {
            for(Unit s: ss) {
                if(posval.contains(s))
                    posval.remove(s.getValue());
            }
        }
        if(posval.size() == 1) {
            value = posval.get(0);
        }
    }

    public String getValue() {
        return value;
    }

    public HashMap<String, Set> getSets() {
        return sets;
    }

    //    public static ArrayList<String> getPosVal(){
//        return posval;
//    }

}