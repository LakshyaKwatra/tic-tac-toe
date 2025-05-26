package lowleveldesign;

import java.util.Optional;

public class AIPlayer extends Player {

    ComputerPlayStrategy computerPlayStrategy;
    public AIPlayer(String name) {
        super(name);
        this.computerPlayStrategy = new RandomComputerPlayStrategy();
    }
    public AIPlayer(String name, ComputerPlayStrategy computerPlayStrategy) {
        super(name);
        this.computerPlayStrategy = computerPlayStrategy;
    }

    public int[] makeMove(Board board, char symbol) {
        int[] move = this.computerPlayStrategy.makeMove(board, symbol);
        System.out.println(getName() + " (" + symbol + ") plays: " + move[0] + ", " + move[1]);
        return move;
    }

    public Optional<Integer> getRating() {
        return Optional.empty();
    }

    public void setComputerPlayStrategy(ComputerPlayStrategy computerPlayStrategy) {
        this.computerPlayStrategy = computerPlayStrategy;
    }
}
