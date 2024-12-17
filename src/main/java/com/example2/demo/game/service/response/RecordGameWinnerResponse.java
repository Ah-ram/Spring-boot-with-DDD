package com.example2.demo.game.service.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RecordGameWinnerResponse {
    private final String message;

    // 승자 이름을 포함하는 메시지를 반환
    public static RecordGameWinnerResponse winner(String winnerName) {
        return new RecordGameWinnerResponse("승자: " + winnerName);
    }

    // 무승부 결과 메시지를 반환
    public static RecordGameWinnerResponse draw() {
        return new RecordGameWinnerResponse("무승부!");
    }

    // 게임을 찾을 수 없다는 메시지를 반환
    public static RecordGameWinnerResponse gameNotFound() {
        return new RecordGameWinnerResponse("게임을 찾을 수 없습니다!");
    }

    // 플레이어가 없다는 메시지를 반환
    public static RecordGameWinnerResponse noPlayers() {
        return new RecordGameWinnerResponse("플레이어가 없습니다!");
    }
}