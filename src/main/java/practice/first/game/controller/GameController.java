package practice.first.game.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import practice.first.game.entity.Game;
import practice.first.game.service.GameService;
import practice.first.player.entity.Player;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/game")
public class GameController {
    final private GameService gameService;

    @GetMapping("/create-simple-game")
    public Game createGame() {
        log.info("createGame() called!");

        return gameService.createGame();
    }

    @GetMapping("/play")
    public String playGame(@RequestParam int gameId) {
        log.info("Game has been started.");

        String result = gameService.play(gameId);

        return result;
    }

    @GetMapping("record-game-winner")
    public String getGameWinner(@RequestParam int gameId) {
        String winner = gameService.getWinner(gameId);

        return String.format("Winner: %s", winner);
    }

}
