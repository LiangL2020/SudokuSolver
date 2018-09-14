public class Box {

    private Unit[][] units;

    public Box(Unit[][] units) {

        this.units = units;

//if there is a value || only 1 posval        if(){
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                //make 9 units in each box
                //units[r][c] = getValue();
            }
        }
//if ends        }//else if more than 1 posval{
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                //this inserts posval
            }
        }
//else ends    }

    }

    public Unit[][] getUnits() {
        return units;
    }

}
