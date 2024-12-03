package practice.second.game.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.second.game.entity.Game;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class CreateSimpleGameRequest {
    private final List<Long> playerIdList;

    public Game toGame() {
        return new Game(this.playerIdList);
    }
}
