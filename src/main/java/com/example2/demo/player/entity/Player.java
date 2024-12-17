package com.example2.demo.player.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    private String nickname;

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public Player() { }
}
