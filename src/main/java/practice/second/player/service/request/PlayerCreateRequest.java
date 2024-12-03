package practice.second.player.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.second.player.entity.Player;

@Getter
@RequiredArgsConstructor
public class PlayerCreateRequest {
    private final String name;

    public Player toPlayer() {
        return new Player(this.name);
    }
}
