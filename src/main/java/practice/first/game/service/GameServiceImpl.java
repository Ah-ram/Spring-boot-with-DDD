package practice.first.game.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.first.dice.entity.Dice;
import practice.first.dice.repository.DiceRepository;
import practice.first.game.entity.Game;
import practice.first.game.repository.GameRepository;
import practice.first.player.entity.Player;
import practice.first.player.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    final private GameRepository gameRepository;
    final private PlayerRepository playerRepository;
    final private DiceRepository diceRepository;

    @Override
    public Game createGame() {
        return gameRepository.create();
    }

    @Override
    public String play(int gameId) {
        Game game = gameRepository.findById(gameId);
        List<Player> selectGamePlayer = playerRepository.selectPlayer();

        if (selectGamePlayer.isEmpty()) {
            return "게임을 플레이하려면 2명 이상의 플레이어가 필요합니다.";
        }

        Player player1 = selectGamePlayer.getFirst();
        Player player2 = selectGamePlayer.getLast();

        List<Dice> diceList1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Dice dice = diceRepository.rollDice();
            diceList1.add(dice);
        }
        player1.setPlayerDiceList(diceList1);

        List<Dice> diceList2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Dice dice = diceRepository.rollDice();
            diceList2.add(dice);
        }
        player2.setPlayerDiceList(diceList2);

        int score1 = player1.getPlayerScore();
        int score2 = player2.getPlayerScore();

        if (score1 > score2) {
            game.setWinner(player1.getPlayerNickname());
            return String.format("%s가 %d점으로 승리했습니다!", player1.getPlayerNickname(), score1, player2.getPlayerNickname(), score2);
        } else if (score2 > score1) {
            game.setWinner(player2.getPlayerNickname());
            return String.format("%s가 %d점으로 승리했습니다!", player2.getPlayerNickname(), score2, player1.getPlayerNickname(), score1);
        } else {
            game.setWinner("DRAW");
            return "DRAW";
        }
    }

    @Override
    public String getWinner(int gameId) {
        Game game = gameRepository.findById(gameId);
        if (game == null) {
            return "해당 게임을 찾을 수 없습니다.";
        }
        return game.getWinner();
    }
}
