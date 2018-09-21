import java.util.ArrayList;

public class Board {

    private Box[][] boxes = new Box[3][3];
    private Unit[][] units = new Unit[9][9];

    private String[][] starter;

    private Set[] boxSet = new Set[9], rowSet = new Set[9], colSet = new Set[9];

    public Board(String[][] starter){

        this.starter = starter;
        ArrayList<Unit>[] boxSets = new ArrayList[9];
        for (int i = 0; i < 9; i++) {
            boxSets[i] = new ArrayList<Unit>();
        }
        for (int i = 0; i < starter.length; i++) {
            for (int j = 0; j < starter[0].length; j++) {
                Unit unit = new Unit(starter[i][j]);
                units[i][j] = unit;
                int boxIdx = i/3*3 + j/3;
                boxSets[boxIdx].add(unit);
            }
        }

        for (int i = 0; i < 9; i++) {
            Unit[] box = new Unit[9];
            for (int j = 0; j < 9; j++) {
                box[j] = boxSets[i].get(j);
            }
            boxSet[i] = new Set(box, "box");
            rowSet[i] = new Set(units[i], "row");
            Unit[] list = new Unit[9];
            for (int j = 0; j < 9; j++) {
                list[j] = units[j][i];
            }
            colSet[i] = new Set(list, "col");
        }
        //TURN VALS INTO UNITS

        //makes the board
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                //making 9 boxes per board
//
//                Unit[][] temp = new Unit[3][3];
//
//                for (int k = 0; k < 3; k++) {
//                    for (int l = 0; l < 3; l++) {
//                        //making 9 units per box
//
//                        temp[k][l] = new Unit(starter[i*3+k][j*3+l]);
//                        allUnits[i*3+k][j*3+l] = temp[k][l];
//                    }
//                }
//
//                boxes[i][j] = new Box(temp);
//                Set box = new Set("box", boxes[i][j]);
//                for(Unit[] units : temp){
//                    for(Unit unit : units){
//                        unit.addSet()
//                    }
//                }
//            }
//
//        }
//        ArrayList<Unit>[] boxSets = new ArrayList[9];
//
//        boxes = new Set[9];
//        for (int i = 0; i < 9; i++) {
//            boxSets[i] = new ArrayList<Cell>();
//        }
//        for (int i = 0; i < values.length; i++) {
//            for (int j = 0; j < values[0].length; j++) {
//                Cell cell = new Cell(values[i][j], i, j, this);
//                cells[i][j] = cell;
//                int boxIdx = i/3*3 + j/3;
//                boxSets[boxIdx].add(cell);
//            }
//        }
//
//        for (int i = 0; i < 9; i++) {
//            Cell[] box = new Cell[9];
//            for (int j = 0; j < 9; j++) {
//                box[j] = boxSets[i].get(j);
//            }
//            boxes[i] = new Set(box, "box");
//            rows[i] = new Set(cells[i], "row");
//            Cell[] list = new Cell[9];
//            for (int j = 0; j < 9; j++) {
//                list[j] = cells[j][i];
//            }
//            cols[i] = new Set(list, "col");
//        }


    }

    public void update() {
        for(Unit[] list : units){
            for(Unit unit : list){
                unit.update();
            }
        }

//        for(Box[] bb: boxes) {
//            for(Box b: bb) {
//
//                for(Unit[] uu: b.getUnits()) {
//                    for(Unit u: uu) {
//                        String[] tempRow = new String[9];
//                        String[] tempCol = new String[9];
//                        for (int i = 0; i < 3; i++) {
//                            for (int j = 0; j < 3; j++) {
//                                for (int k = 0; k < 3; k++) {
//                                    for (int l = 0; l < 3; l++) {
//                                        for (int m = 0; m < 9; m++) {
//                                            tempCol[m] = starter[m][j*l];
//                                            tempRow[m] = starter[i*k][m];
//                                        }
//                                        u.update(tempRow, tempCol, b.getUnits());
//                                    }
//                                }
//                            }
//                        }
//
//                    }
//                }
//            }
//        }
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(units[i][j].getValue() + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    //checks if the numbers are 1-9
    public boolean checkRow(int row){
        int[] check = new int[9]; //counter...check[0] counts the number of 1's in row, [1] counts 2's....

        for (int j = 0; j < check.length; j++) {
            String value = boxes[row/3][j/3].getUnits()[row%3][j%3].getValue();

            int num = Integer.parseInt(value);
            check[num-1]++;
        }

        for(int n : check)
            if(n > 1)
                return false;
        return true;
    }

    //TODO: finish
    public boolean checkCol(int col){
        int[] check = new int[9];

        for (int i = 0; i < 9; i++) {
            String value = boxes[i/3][col/3].getUnits()[i%3][col%3].getValue();

            int num = Integer.parseInt(value);
            check[num-1]++;
        }

        for(int n : check){
            if(n > 1)
                return false;
        }
        return true;
    }

}