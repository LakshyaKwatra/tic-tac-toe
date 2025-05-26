package lowleveldesign;

import java.util.Optional;
import java.util.Scanner;

public class NormalPlayer extends Player {

    private int rating;

    public NormalPlayer(String name) {
        super(name);
        this.rating = 1000;
    }

    public Optional<Integer> getRating() {
        return Optional.of(rating);
    }

    public void updateRating(int delta) {
        rating += delta;
    }

    public int[] makeMove(Board board, char symbol) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getName() + " (" + symbol + ") enter your move (row and column): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row,col};
    }

}
