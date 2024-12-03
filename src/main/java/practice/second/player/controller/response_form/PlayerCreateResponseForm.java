package practice.second.player.controller.response_form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.second.player.service.response.PlayerCreateResponse;

@Getter
@RequiredArgsConstructor
public class PlayerCreateResponseForm {
    private final String nickname;
    private final boolean success;

    public static PlayerCreateResponseForm from(PlayerCreateResponse playerCreateResponse) {
        return new PlayerCreateResponseForm(playerCreateResponse.getNickname(), playerCreateResponse.isSuccess());
    }
}
