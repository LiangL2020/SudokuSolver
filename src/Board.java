import java.util.ArrayList;

public class Board {

    private Box[][] boxes = new Box[3][3];

    private String[][] starter;

    public Board(String[][] starter){

        this.starter = starter;

        //TURN VALS INTO UNITS

        //makes the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //making 9 boxes per board

                Unit[][] temp = new Unit[3][3];
                String[] tempRow = new String[9];
                String[] tempCol = new String[9];

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        //making 9 units per box

                        //initialize row and col
                        for (int a = 0; a < 9; a++) {

                            tempRow[a] = starter[a][j*l];
                            tempCol[a] = starter[i*k][a];

                        }

                        temp[k][l] = new Unit(starter[i*3+k][j*3+l]);

                    }
                }

                boxes[i][j] = new Box(temp);

            }

        }

    }

    public void update() {
        for(Box[] bb: boxes) {
            for(Box b: bb) {

                for(Unit[] uu: b.getUnits()) {
                    for(Unit u: uu) {

                    }
                }

            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {

                        System.out.print(boxes[i][k].getUnits()[j][l].getValue() + " ");

                    }
                }

                System.out.println();

            }
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