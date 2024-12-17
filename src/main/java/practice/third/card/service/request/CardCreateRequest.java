package practice.third.card.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.third.card.entity.Card;
import practice.third.card.entity.CardName;
import practice.third.card.entity.CardPlacement;
import practice.third.card.entity.CardStatusEffect;

@Getter
@RequiredArgsConstructor
public class CardCreateRequest {
    private final Long cardNumber;

    public Card toCard(CardName cardName, CardPlacement placement, CardStatusEffect statusEffect) {
        return new Card(cardName, placement, statusEffect);
    }
}
