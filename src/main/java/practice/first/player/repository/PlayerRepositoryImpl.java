package practice.first.player.repository;

import org.springframework.stereotype.Repository;
import practice.first.dice.entity.Dice;
import practice.first.dice.repository.DiceRepository;
import practice.first.player.entity.Player;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerRepositoryImpl implements PlayerRepository {

    static List<Player> playerList = new ArrayList<>();

    final String playerNickname = "player0";
    int playerCount = 0;

    @Override
    public Player create() {
        int id = ++playerCount;
        String nickname = playerNickname + id;
        Player player = new Player(id, nickname);

        playerList.add(player);

        return player;
    }

    @Override
    public List<Player> getPlayerList() {
        return playerList;
    }

    @Override
    public List<Player> selectPlayer() {
        int LengthOfPlayerList = playerList.size();

        if (LengthOfPlayerList < 2) {
            return List.of();
        }

        List<Player> gamePlayerList = new ArrayList<>();

        int idx1 = (int) (Math.random() * LengthOfPlayerList);
        int idx2 = (int) (Math.random() * LengthOfPlayerList);

        while (idx1 == idx2) {
            idx2 = (int) (Math.random() * LengthOfPlayerList);
        }

        Player player1 = playerList.get(idx1);
        Player player2 = playerList.get(idx2);

        gamePlayerList.add(player1);
        gamePlayerList.add(player2);

        return gamePlayerList;
    }
    // List Length = 6 >> List index 0 ~ 5
    // Math.random -> 0 ~ 0.999999999... 까지니까
    // Math.random * List Length % List Length -> 0 ~ 5 index1
    // index2 -> index1이랑 같은 방법인데, 두개가 서로 달라야된다.
    // index2 = Math.random * List Length % List Length
    // while (index2 == index1) index2 = Math.random * List Length % List Length

}
