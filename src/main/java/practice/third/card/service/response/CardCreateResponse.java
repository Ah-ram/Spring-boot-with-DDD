package practice.third.card.service.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.third.card.entity.Card;

@Getter
@RequiredArgsConstructor
public class CardCreateResponse {
    private final String cardName;
    private final String cardPlacement;
    private final String cardStatusEffect;
    private final String graphicTextureName;
    private final Long damage;
    private final Long hp;

    public static CardCreateResponse from(Card card, )
}
