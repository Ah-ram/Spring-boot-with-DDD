package practice.second.player.controller.request_form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.second.player.service.request.PlayerFindRequest;

@Getter
@RequiredArgsConstructor
public class PlayerFindRequestForm {
    private final Long playerId;

    public PlayerFindRequest toPlayerFindRequest() {
        return new PlayerFindRequest(this.playerId);
    }
}
