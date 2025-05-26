package lowleveldesign;

import java.util.HashMap;
import java.util.Map;

public class Game {
    Board board;
    Player player1;
    Player player2;
    Map<Player, Character> playerSymbolMap = new HashMap<>();
    Player currentPlayer;

    private static final int winPoints = 10;
    private static final int losePoints = -5;
    private static final int drawPoints = 2;

    public Game(GameBuilder gameBuilder) {
        this.board = gameBuilder.board;
        this.player1 = gameBuilder.player1;
        this.player2 = gameBuilder.player2;
        playerSymbolMap.put(player1, gameBuilder.symbol1);
        playerSymbolMap.put(player2, gameBuilder.symbol2);
        this.currentPlayer = player1;
    }

    public void start() {
        while (true) {
            board.printBoard();
            char currentSymbol = playerSymbolMap.get(currentPlayer);
            System.out.println(currentPlayer.getName() + "'s turn (" + currentSymbol + ")");
            int[] move = currentPlayer.makeMove(board, currentSymbol);

            if(!board.isValidMove(move[0], move[1])) {
                System.out.println("Invalid move!");
                continue;
            }

            board.fillCell(move[0], move[1], currentSymbol);

            if(board.checkWin(move[0], move[1], currentSymbol)) {
                board.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                updateRatings(false);
                break;
            }

            if(board.areAllCellsFilled()) {
                board.printBoard();
                System.out.println("It's a draw!");
                updateRatings(true);
                break;
            }

            currentPlayer = getOpponent(currentPlayer);
        }
    }

    private void updateRatings(boolean isDraw) {
        if(isDraw) {
            currentPlayer.getRating().ifPresent(r -> {
                ((NormalPlayer) currentPlayer).updateRating(drawPoints);
                System.out.println(currentPlayer.getName() + " rating: " + currentPlayer.getRating().get());
            });
            Player opponent = getOpponent(currentPlayer);
            opponent.getRating().ifPresent(r -> {
                ((NormalPlayer) opponent).updateRating(drawPoints);
                System.out.println(opponent.getName() + " rating: " + opponent.getRating().get());
            });
        } else {
            currentPlayer.getRating().ifPresent(r -> {
                ((NormalPlayer) currentPlayer).updateRating(winPoints);
                System.out.println(currentPlayer.getName() + " rating: " + currentPlayer.getRating().get());
            });
            Player opponent = getOpponent(currentPlayer);
            opponent.getRating().ifPresent(r -> {
                ((NormalPlayer) opponent).updateRating(losePoints);
                System.out.println(opponent.getName() + " rating: " + opponent.getRating().get());
            });
        }
    }

    private Player getOpponent(Player player) {
        return player == player1 ? player2 : player1;
    }




    public static class GameBuilder {
        private Board board;
        private Player player1;
        private Player player2;
        private Character symbol1;
        private Character symbol2;

        public GameBuilder() {
        }

        GameBuilder boardSize(int size) {
            this.board = new Board(size);
            return this;
        }

        GameBuilder player1(Player player1) {
            this.player1 = player1;
            return this;
        }

        GameBuilder player2(Player player2) {
            this.player2 = player2;
            return this;
        }

        GameBuilder symbol1(Character symbol1) {
            this.symbol1 = symbol1;
            return this;
        }

        GameBuilder symbol2(Character symbol2) {
            this.symbol2 = symbol2;
            return this;
        }

        Game build() {
            return new Game(this);
        }

    }
}
