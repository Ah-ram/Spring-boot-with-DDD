package practice.first.game.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private int gameId;
    private String winner;

    public Game(int gameId) {
        this.gameId = gameId;
    }

    public String getWinner() {
        return this.winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
