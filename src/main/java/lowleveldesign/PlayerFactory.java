package lowleveldesign;

public class PlayerFactory {

    Player getPlayer(String playerType, String name) {
        switch (playerType.toUpperCase()) {
            case "NORMAL":
                return new NormalPlayer(name);
            case "AI":
                return new AIPlayer(name);
            default:
                throw new IllegalArgumentException("Invalid player type!");
        }
    }
}
