import java.util.ArrayList;

public class Unit {

    private int value;
    //current value of unit

    ArrayList<Integer> posval = new ArrayList<Integer>();
    //possible values of unit

    public Unit(int value) {

        this.value = value;

        for (int i = 0; i < 9; i++) {

            posval.add(i + 1);

        }

    }

}
