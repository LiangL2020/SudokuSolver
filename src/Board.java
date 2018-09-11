public class Board {

    private Box[][] boxes = new Box[3][3];

    private Board(Box[][] boxes){

        this.boxes = boxes;

    }

    //check if it is in the box
    public boolean isValid(){
        for (int r = 0; r < boxes.length; r++) {
            for (int c = 0; c < boxes[0].length; c++) {
                return true;
            }
        }
        return false;
    }

}
