package practice.second.player.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.second.player.controller.request_form.PlayerCreateRequestForm;
import practice.second.player.controller.response_form.PlayerCreateResponseForm;
import practice.second.player.controller.request_form.PlayerFindRequestForm;
import practice.second.player.service.response.PlayerCreateResponse;
import practice.second.player.service.PlayerService;
import practice.second.player.entity.Player;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/second-player")
public class PlayerController {
    final private PlayerService playerService;

    @GetMapping("/create")
    // @ModelAttribute는 요청 데이터를 객체로 바인딩하는데 사용
    // 클라이언트로부터 전달된 요청 파라미터나 데이터 자동 매핑
    public PlayerCreateResponseForm createPlayer(@ModelAttribute PlayerCreateRequestForm playerCreateRequestForm) {
        log.info("createPlayer() called!");

        PlayerCreateResponse response = playerService.createPlayer(playerCreateRequestForm.toPlayerCreateRequest());
        return PlayerCreateResponseForm.from(response);
    }

    @GetMapping("/find-player")
    public Player findPlayer(@ModelAttribute PlayerFindRequestForm playerFindRequestForm) {
        log.info("findPlayer() called!");

        Player foundPlayer = playerService.findPlayer(playerFindRequestForm.toPlayerFindRequest());
        return foundPlayer;
    }

    @GetMapping("/list")
    public List<Player> listPlayer() {
        log.info("listPlayer() called!");

        List<Player> responseList = playerService.listPlayer();
        return responseList;
    }
}
