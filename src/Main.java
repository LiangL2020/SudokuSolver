import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        File[] puzzles = new File("Puzzles").listFiles();

        for(File puzzle: puzzles) {

            BufferedReader br = new BufferedReader(new FileReader(puzzle));

            Map<String, Board> boards = new HashMap<String, Board>();
            String name = puzzle.getName();

            String[][] vals = new String[9][9];

            for (int i = 0; i < 9; i++) {

                String[] currentLine = br.readLine().split(" ");
                vals[i] = currentLine;

            }

            Board b = new Board(vals);

            System.out.println("Puzzle: " + name);
            System.out.println("Initial:");
            b.printBoard();
            b.update();
            System.out.println("Solved:");
            b.printBoard();

            //this isnt really necessary
            boards.put(name, b);

        }

    }

}