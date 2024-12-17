//package com.example2.demo.game.service;
//
//
//import com.example2.demo.dice.repository.DiceRepository;
//import com.example2.demo.game.entity.Game;
//import com.example2.demo.game.repository.GameRepository;
//import com.example2.demo.game.service.request.CheckGameRequest;
//import com.example2.demo.game.service.request.RecordGameWinnerRequest;
//import com.example2.demo.game.service.response.CheckGameResponse;
//import com.example2.demo.game.service.response.CreateSimpleGameResponse;
//import com.example2.demo.game.service.response.RecordGameWinnerResponse;
//import com.example2.demo.player.entity.Player;
//import com.example2.demo.player.repository.PlayerRepository;
//import com.example2.demo.player.service.response.PlayerCreateResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class GameServiceImpl implements GameService {
//    final private GameRepository gameRepository;
//    final private PlayerRepository playerRepository;
//    final private DiceRepository diceRepository;
//
//    final int DRAW = -1;
//
//    @Override
//    public CreateSimpleGameResponse createSimpleGame() {
//        List<Player> playerList = playerRepository.findAll();
//        List<Integer> playerIdList = new ArrayList<>();
//
//        for (Player player : playerList) {
//            for (int i = 0; i < 3; i++) {
//                int diceId = diceRepository.rollDice();
//                player.addDiceId(diceId);
//            }
//
//            playerIdList.add(player.getId());
//        }
//
//        int gameId = gameRepository.create(playerIdList);
//
//        return CreateSimpleGameResponse.from(gameId);
//    }
//
//    private List<Player> findPotentialWinners(List<Player> playerList) {
//        int highestSum = 0;
//        List<Player> potentialWinners = new ArrayList<>();
//
//        for (Player player : playerList) {
//            int diceSum = calculateDiceSum(player);
//
//            if (diceSum > highestSum) {
//                highestSum = diceSum;
//                potentialWinners.clear();
//                potentialWinners.add(player);
//                continue;
//            }
//
//            if (diceSum == highestSum) {
//                potentialWinners.add(player);
//            }
//        }
//
//        return potentialWinners;
//    }
//
//    private int calculateDiceSum(Player player) {
//        return player.getDiceIdList().stream().mapToInt(Integer::intValue).sum();
//    }
//
//    @Override
//    public RecordGameWinnerResponse recordGameWinner(RecordGameWinnerRequest gameCheckWinnerRequest) {
//        Optional<Game> maybeGame = gameRepository.findById(gameCheckWinnerRequest.getGameId());
//
//        if (maybeGame.isEmpty()) {
//            return RecordGameWinnerResponse.gameNotFound();
//        }
//
//        Game game = maybeGame.get();
//        List<Integer> playerIdList = game.getPlayerIdList();
//
//        if (playerIdList.isEmpty()) {
//            return RecordGameWinnerResponse.noPlayers();
//        }
//
//        List<Player> playerList = playerRepository.findByIdIn(playerIdList);
//        List<Player> potentialWinners = findPotentialWinners(playerList);
//
//        if (potentialWinners.size() > 1) {
//            gameRepository.recordGame(game.getId(), DRAW);
//
//            return RecordGameWinnerResponse.draw();
//        }
//
//        Player winner = potentialWinners.get(0);
//        gameRepository.recordGame(game.getId(), winner.getId());
//
//        return RecordGameWinnerResponse.winner(winner.getNickname());
//    }
//
//    @Override
//    public CheckGameResponse checkGame(CheckGameRequest checkGameRequest) {
//        Optional<Game> maybeGame = gameRepository.findById(checkGameRequest.getGameId());
//
//        if (maybeGame.isEmpty()) {
//            return new CheckGameResponse("게임을 찾을 수 없습니다.");
//        }
//
//        Game game = maybeGame.get();
//        int winnerId = game.getWinnerId();
//        System.out.println("winnerId: " + winnerId);
//
//        if (winnerId <= 0) {
//            return new CheckGameResponse("게임의 승자가 없습니다.");
//        }
//
//        return new CheckGameResponse("승자: " + winnerId);
//    }
//}