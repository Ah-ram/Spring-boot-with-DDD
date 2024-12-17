package com.example2.demo.player.service;

import com.example2.demo.player.controller.request_form.PlayerCreateRequestForm;
import com.example2.demo.player.entity.Player;
import com.example2.demo.player.service.request.PlayerCreateRequest;
import com.example2.demo.player.service.request.PlayerFindRequest;
import com.example2.demo.player.service.response.PlayerCreateResponse;

import java.util.List;

public interface PlayerService {
    PlayerCreateResponse createPlayer(PlayerCreateRequest playerCreateRequest);
    Player findPlayer(PlayerFindRequest playerFindRequest);
    List<Player> listPlayer();
}
