//package com.example2.demo.game.controller;
//
//import com.example2.demo.game.controller.request_form.CheckGameRequestForm;
//import com.example2.demo.game.controller.request_form.RecordGameWinnerRequestForm;
//import com.example2.demo.game.controller.response_form.CheckGameResponseForm;
//import com.example2.demo.game.controller.response_form.CreateSimpleGameResponseForm;
//import com.example2.demo.game.controller.response_form.RecordGameWinnerResponseForm;
//import com.example2.demo.game.service.GameService;
//import com.example2.demo.game.service.response.CheckGameResponse;
//import com.example2.demo.game.service.response.CreateSimpleGameResponse;
//import com.example2.demo.game.service.response.RecordGameWinnerResponse;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/game")
//public class GameController {
//
//    final private GameService gameService;
//
//    @GetMapping("/create-simple-game")
//    public CreateSimpleGameResponseForm createSimpleGame() {
//        log.info("createSimpleGame() called");
//
//        CreateSimpleGameResponse response = gameService.createSimpleGame();
//
//        return CreateSimpleGameResponseForm.from(response);
//    }
//
//    @GetMapping("/record-game-winner")
//    public RecordGameWinnerResponseForm recordGameWinner(@ModelAttribute RecordGameWinnerRequestForm gameCheckWinnerRequestForm) {
//        log.info("recordGameWinner() called");
//
//        RecordGameWinnerResponse response = gameService.recordGameWinner(gameCheckWinnerRequestForm.toRecordGameWinnerRequest());
//
//        return RecordGameWinnerResponseForm.from(response);
//    }
//
//    @GetMapping("/check-game")
//    public CheckGameResponseForm checkGame(@ModelAttribute CheckGameRequestForm checkGameRequestForm) {
//        log.info("checkGame() called");
//
//        CheckGameResponse response = gameService.checkGame(checkGameRequestForm.toCheckGameRequest());
//
//        return CheckGameResponseForm.from(response);
//    }
//}