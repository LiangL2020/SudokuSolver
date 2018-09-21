import java.util.ArrayList;
import java.util.HashMap;

public class Unit {

    private String value;
    //current value of unit

    ArrayList<String> posval = new ArrayList<String>();
    //possible values of unit
    private HashMap<String, Set> sets;
    public Unit(String value) {
        this.value = value;
        sets = new HashMap<String, Set>();
        if(value.equals("0")){
            for (int i = 0; i < 9; i++) {

                posval.add(String.valueOf(i + 1));

            }
        }
        else{
            posval.add(value);
        }

    }

    public void addSet(Set set){
        sets.put(set.getName(), set);
    }

    public boolean hasOption(String value) {
        return !(posval.indexOf(value) == -1);
    }

    public void update(){
        if(posval.size() == 1) {
            value = posval.get(0);
            for(String s : sets.keySet()){
                for(Unit unit : sets.get(s).getUnits()){
                    unit.removeOption(value);
                }
                sets.get(s).update();
            }
        }

    }

    public String getValue() {
        return value;
    }

    public void setValue(String val){
        if(value.equals ("0")) {
            posval = new ArrayList<String>();
            posval.add(val);
            update();
        }
    }

    public HashMap<String, Set> getSets() {
        return sets;
    }

    public void removeOption(String val){
        int idx = posval.indexOf(val);
        if(idx != -1){
            posval.remove(idx);
            update();
        }

    }

    //    public static ArrayList<String> getPosVal(){
//        return posval;
//    }

}