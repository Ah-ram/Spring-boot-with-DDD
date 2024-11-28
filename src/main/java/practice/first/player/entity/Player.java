package practice.first.player.entity;

import lombok.Getter;
import lombok.Setter;
import practice.first.dice.entity.Dice;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Player {

    private int id;
    private String nickname;
    private List<Dice> diceList = List.of();

    public Player(int id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public String getPlayerNickname() {
        return this.nickname;
    }

    public void setPlayerDiceList(List<Dice> diceList) {
        this.diceList = diceList;
    }

    public Integer getPlayerScore() {
        int playerScore = 0;
        for (Dice dice: this.diceList) {
            playerScore += dice.getDiceNumber();
        }

        return playerScore;
    }
}
