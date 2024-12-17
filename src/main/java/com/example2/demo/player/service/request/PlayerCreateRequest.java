package com.example2.demo.player.service.request;

import com.example2.demo.player.entity.Player;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PlayerCreateRequest {
    private final String name;

    public Player toPlayer() {
        return new Player(this.name);
    }
}