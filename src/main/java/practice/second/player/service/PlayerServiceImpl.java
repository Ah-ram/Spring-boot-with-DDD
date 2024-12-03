package practice.second.player.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import practice.second.dice.repository.DiceRepository;
import practice.second.player.entity.Player;
import practice.second.player.repository.PlayerRepository;
import practice.second.player.service.request.PlayerCreateRequest;
import practice.second.player.service.request.PlayerFindRequest;
import practice.second.player.service.response.PlayerCreateResponse;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService{
    final private PlayerRepository playerRepository;
    final private DiceRepository diceRepository;

    @Override
    public PlayerCreateResponse createPlayer(PlayerCreateRequest playerCreateRequest) {
        Player player = playerCreateRequest.toPlayer();
        Player createdPlayer = playerRepository.save(player);

        return PlayerCreateResponse.from(createdPlayer);
    }

    @Override
    public Player findPlayer(PlayerFindRequest playerFindRequest) {
        Optional<Player> maybePlayer = playerRepository.findById(playerFindRequest.getPlayerId());
        if (maybePlayer.isEmpty()) {
            log.info("해당 playerId로 찾는 Player가 없습니다.");
            return null;
        }

        return maybePlayer.get();
    }

    @Override
    public List<Player> listPlayer() {
        List<Player> playerList = playerRepository.findAll();
        return playerList;
    }
}
