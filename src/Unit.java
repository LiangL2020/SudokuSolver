import java.util.ArrayList;

public class Unit {

    private String value;
    //current value of unit

    ArrayList<String> posval = new ArrayList<String>();
    //possible values of unit

    public Unit(String value) {

        this.value = value;

        for (int i = 0; i < 9; i++) {

            posval.add(String.valueOf(i + 1));

        }

    }

    public void update(String[] row, String[] col, Unit[][] box){
        for(String s: row) {
            posval.remove(s);
        }
        for(String s: col) {
            posval.remove(s);
        }
        for(Unit[] ss: box) {
            for(Unit s: ss) {
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

//    public static ArrayList<String> getPosVal(){
//        return posval;
//    }

}