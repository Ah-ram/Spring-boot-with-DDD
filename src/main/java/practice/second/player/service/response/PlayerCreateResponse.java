package practice.second.player.service.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.second.player.entity.Player;

@Getter
@RequiredArgsConstructor
public class PlayerCreateResponse {
    private final String nickname;
    private final boolean success;

    public static PlayerCreateResponse from(Player player) {
        if (player == null) {
            return new PlayerCreateResponse("", false);
        }

        return new PlayerCreateResponse(player.getNickname(), true);
    }
}
