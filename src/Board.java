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

                        temp[k][l] = new Unit(starter[l*3+j][k*3+i], tempRow, tempCol);

                    }
                }

                boxes[i][j] = new Box(temp);

            }
        }

    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        System.out.print(boxes[i][j].getUnits()[k][l].getValue());
                    }
                }
                System.out.println();
            }
        }
    }

}
