package practice.third.card.controller.request_form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@RequiredArgsConstructor
public class CardCreateRequestForm {
    private final Long cardNumber;

    public CardCreateRequest toCardCreateRequest() {
        return new CardCreateRequest(this.cardNumber);
    }
}
