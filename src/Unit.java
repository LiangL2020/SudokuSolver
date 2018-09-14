import java.util.ArrayList;

public class Unit {

    private String value;
    //current value of unit

    ArrayList<String> posval = new ArrayList<String>();
    //possible values of unit

    private String[] row, col;

    public Unit(String value, String[] row, String[] col) {

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

        for (int i = 0; i < row.length; i++) {

            if(posval.contains(row[i])){

                posval.remove(row[i]);

            }

        }
        for (int i = 0; i < col.length; i++) {

            if(posval.contains(col[i])){

                posval.remove(col[i]);

            }

        }

        //do box stuff

        if(posval.size() <= 1){

            value = posval.get(0);

        }

    }

    public void update(int rc, int pos, String val){
    //row array = 0, col array = 1

        if(rc == 0){//row

            row[pos] = val;

        }
        else{//col

            col[pos] = val;

        }

    }

    public String getValue() {
        return value;
    }

}
