package practice.second.player.service.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.second.dice.entity.Dice;
import practice.second.player.entity.Player;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class PlayerListResponse {
    private final int id;
    private final String nickname;
    private final List<Dice> diceList;

    public static PlayerListResponse from(Player player,List<Dice> diceList) {
        return new PlayerListResponse(player.getId(), player.getNickname(), diceList);
    }

}
