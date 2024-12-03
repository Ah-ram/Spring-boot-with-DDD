package practice.second.player.service;

import practice.second.player.entity.Player;
import practice.second.player.service.request.PlayerCreateRequest;
import practice.second.player.service.request.PlayerFindRequest;
import practice.second.player.service.response.PlayerCreateResponse;

import java.util.List;

public interface PlayerService {
    PlayerCreateResponse createPlayer(PlayerCreateRequest playerCreateRequest);
    Player findPlayer(PlayerFindRequest playerFindRequest);
    List<Player> listPlayer();
}
