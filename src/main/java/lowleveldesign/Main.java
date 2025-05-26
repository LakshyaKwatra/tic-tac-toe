package lowleveldesign;

public class Main {
    public static void main(String[] args) {

        PlayerFactory playerFactory = new PlayerFactory();
        Player player1 = playerFactory.getPlayer("normal", "Player-1");
        Player player2 = playerFactory.getPlayer("normal", "Player-2");
        Player computer1 = playerFactory.getPlayer("ai", "Computer-1");
        Player computer2 = playerFactory.getPlayer("ai", "Computer-2");
        Game game = new Game.GameBuilder()
                .player1(player1)
                .player2(player2)
                .symbol1('X')
                .symbol2('O')
                .boardSize(3)
                .build();
        game.start();
    }
}