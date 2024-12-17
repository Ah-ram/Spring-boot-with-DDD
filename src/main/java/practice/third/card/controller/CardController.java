package practice.third.card.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;

    @PostMapping("/create")
    public CardCreateResponseForm create(
            @RequestBody CardCreateRequestForm cardCreateRequestForm) {
        log.info("card controller -> create() called!");

        CardCreateResponse response = cardService.create(CardCreateRequestForm.toCardCreateRequest());
        return CardCreateResponseForm.from(response);
    }
}
