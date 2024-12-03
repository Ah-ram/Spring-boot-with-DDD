package practice.second.player.controller.request_form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.second.player.service.request.PlayerCreateRequest;

@Getter
@RequiredArgsConstructor
public class PlayerCreateRequestForm {
    private final String name;

    public PlayerCreateRequest toPlayerCreateRequest() {
        return new PlayerCreateRequest(this.name);
    }
}
