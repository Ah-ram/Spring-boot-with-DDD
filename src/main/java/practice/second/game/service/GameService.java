package practice.second.game.service;

import practice.second.game.service.request.CheckGameRequest;
import practice.second.game.service.request.RecordGameWinnerRequest;
import practice.second.game.service.response.CheckGameResponse;
import practice.second.game.service.response.CreateSimpleGameResponse;
import practice.second.game.service.response.RecordGameWinnerResponse;

public interface GameService {
    CreateSimpleGameResponse createSimpleGame();
    RecordGameWinnerResponse recordGameWinner(RecordGameWinnerRequest recordGameWinnerRequest);
    CheckGameResponse checkGame(CheckGameRequest checkGameRequest);
}
