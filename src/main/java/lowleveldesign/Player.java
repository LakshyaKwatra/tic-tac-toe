package lowleveldesign;

import java.util.Optional;

public abstract class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int[] makeMove(Board board, char symbol);

    public abstract Optional<Integer> getRating();
}
