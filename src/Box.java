public class Box {

    private Unit[][] units;

    public Box(Unit[][] units) {

        this.units = units;

        //TODO: ************
        //TODO: IM NOT SURE IF WE NEED THIS CLASS, YOU CAN DELETE IT IF NOT NEEDED
        //TODO: I didn't even finish sorry lol
        //TODO: ************
//if there is a value || only 1 posval        if(){
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                //make 9 units in each box
                //units[r][c] = Unit.getValue();

                /*
                TODO: 1. try to make the posval into Uniit??
                TODO: 2. return the posval as a value if only one posval availale
                TODO: 3. if not, then keep checking
                 */
//                if(){
//                    units[r][c] = Unit.getPosVal();
//if ends        }//else if more than 1 posval{
//
////else ends    }

            }
        }

    }

    public Unit[][] getUnits() {
        return units;
    }

}