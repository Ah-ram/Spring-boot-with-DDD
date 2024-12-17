package practice.second.game.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.second.dice.entity.Dice;
import practice.second.dice.repository.DiceRepository;
import practice.second.game.entity.Game;
import practice.second.game.repository.GameRepository;
import practice.second.game.service.request.CheckGameRequest;
import practice.second.game.service.request.CreateSimpleGameRequest;
import practice.second.game.service.request.RecordGameWinnerRequest;
import practice.second.game.service.response.CheckGameResponse;
import practice.second.game.service.response.CreateSimpleGameResponse;
import practice.second.game.service.response.RecordGameWinnerResponse;
import practice.second.player.entity.Player;
import practice.second.player.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    final private GameRepository gameRepository;
    final private PlayerRepository playerRepository;
    final private DiceRepository diceRepository;

    final int DRAW = -1;

    @Override
    public CreateSimpleGameResponse createSimpleGame() {
        List<Player> playerList = playerRepository.findAll();  // 모든 플레이어 정보를 조회하여 리스트로 반환
        List<Long> playerIdList = new ArrayList<>();  // 게임에 참여한 플레이어의 ID를 저장하는 리스트

        for (Player player : playerList) {
            player.clearDiceIdList();  // 새로운 게임 실행 시 각 플레이어의 diceIdList 초기화
            for (int i = 0; i < 3; i++) {
                long randomNumber = (long)(Math.random() * 6) + 1;  // Math.random()을 사용해 주사위 숫자(1~6) 랜덤 생성
                Dice dice = new Dice(randomNumber);  // randomNumber를 받아 새로운 주사위 생성
                Dice createdDice = diceRepository.save(dice);  // 생성된 주사위 객체 저장

                player.addDiceId(createdDice.getNumber());  // 플레이어 객체에 생성한 주사위 번호 추가
                playerRepository.save(player);  // 업데이트된 플레이어 저장
            }

            playerIdList.add((long)player.getId());  // 플레이어의 ID를 playerIdList에 추가
        }

        CreateSimpleGameRequest createSimpleGameRequest = new CreateSimpleGameRequest(playerIdList);
        Game game = createSimpleGameRequest.toGame();
        Game createdGame = gameRepository.save(game);

        return CreateSimpleGameResponse.from(createdGame.getId());
    }

    private List<Player> findPotentialWinners(List<Player> playerList) {
        int highestSum = 0;
        List<Player> potentialWinners = new ArrayList<>();

        for (Player player : playerList) {
            int diceSum = calculateDiceSum(player);

            if (diceSum > highestSum) {
                highestSum = diceSum;
                potentialWinners.clear();
                potentialWinners.add(player);
                continue;
            }

            if (diceSum == highestSum) {
                potentialWinners.add(player);
            }
        }

        return potentialWinners;
    }

    private int calculateDiceSum(Player player) {
        return player.getDiceIdList().stream().mapToInt(Long::intValue).sum();
    }   // 플레이어 객체의 diceIdList를 stream으로 변환
        // Long 타입을 int로 변환하여 합산

    @Override
    public RecordGameWinnerResponse recordGameWinner(RecordGameWinnerRequest gameCheckWinnerRequest) {
        Optional<Game> maybeGame = gameRepository.findById(gameCheckWinnerRequest.getGameId());
        // Optional은 값이 있을수도 없을수도 있는 객체를 제어

        if (maybeGame.isEmpty()) {
            return RecordGameWinnerResponse.gameNotFound();
        }

        Game game = maybeGame.get();
        List<Long> playerIdList = game.getPlayerIdList();

        if (playerIdList.isEmpty()) {
            return RecordGameWinnerResponse.noPlayers();
        }

        List<Player> playerList = playerRepository.findByIdIn(playerIdList);
        List<Player> potentialWinners = findPotentialWinners(playerList);

        if (potentialWinners.size() > 1) {
            game.setWinner(DRAW);
            gameRepository.save(game);

            return RecordGameWinnerResponse.draw();
        }

        Player winner = potentialWinners.getFirst();
        game.setWinner(winner.getId());
        gameRepository.save(game);

        return RecordGameWinnerResponse.winner(winner.getNickname());
    }

    @Override
    public CheckGameResponse checkGame(CheckGameRequest checkGameRequest) {
        Optional<Game> maybeGame = gameRepository.findById(checkGameRequest.getGameId());

        if (maybeGame.isEmpty()) {
            return new CheckGameResponse("게임을 찾을 수 없습니다.");
        }

        Game game = maybeGame.get();
        int winnerId = game.getWinnerId();
        System.out.println("winnerId: " + winnerId);

        if (winnerId <= 0) {
            return new CheckGameResponse("게임의 승자가 없습니다.");
        }

        return new CheckGameResponse("승자: " + winnerId);
    }
}