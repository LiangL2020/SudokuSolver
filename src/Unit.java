import java.util.ArrayList;

public class Unit {

    private int value;
    //current value of unit

    ArrayList<String> posval = new ArrayList<String>();
    //possible values of unit

    private String[] row, col;

    public Unit(int value, String[] row, String[] col) {

        this.value = value;

        for (int i = 0; i < 9; i++) {

            posval.add(String.valueOf(i + 1));

        }

        this.row = row;

        this.col = col;

    }

    public String[] getRow() {
        return row;
    }

    public String[] getCol() {
        return col;
    }

    public void check(){



    }



}
