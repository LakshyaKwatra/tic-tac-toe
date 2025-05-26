package lowleveldesign;

import java.util.Random;

public class RandomComputerPlayStrategy implements ComputerPlayStrategy {

    @Override
    public int[] makeMove(Board board, char symbol) {
        Random random = new Random();
        int size = board.getSize();
        int row, col;
        do {
            row = random.nextInt(size);
            col = random.nextInt(size);
        } while(!board.isValidMove(row, col));
        return new int[]{row,col};
    }
}
