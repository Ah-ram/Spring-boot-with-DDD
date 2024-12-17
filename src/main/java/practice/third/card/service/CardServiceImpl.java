package practice.third.card.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.third.card.entity.*;
import practice.third.card.repository.CardNameRepository;
import practice.third.card.repository.CardRepository;
import practice.third.card.service.request.CardCreateRequest;
import practice.third.card.service.response.CardCreateResponse;
import practice.third.graphic_texture.entity.GraphicTexture;
import practice.third.graphic_texture.entity.GraphicTextureName;
import practice.third.graphic_texture.repository.GraphicTextureRepository;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService{
    private final CardRepository cardRepository;
    private final GraphicTextureRepository graphicTextureRepository;
    private final CardNameRepository cardNameRepository;

    @Override
    public CardCreateResponse create(CardCreateRequest cardCreateRequest) {
        GraphicTexture graphicTexture = graphicTextureRepository.findByCardNumber(
                cardCreateRequest.getCardNumber());
        GraphicTextureName graphicTextureName = graphicTexture.getGraphicTextureName();
        Long value = graphicTextureName.getValue();
        String textureName = GraphicTextureName.getNameByValue(value);

        CardName cardName = cardNameRepository.getCardNameByValue(value);

        Card card = cardCreateRequest.toCard(
                cardName,
                CardPlacement.HAND,
                CardStatusEffect.NORMAL
        );

        Card createdCard = cardRepository.save(card);

        CardHP cardHP = new CardHP((long) 10, graphicTexture, card);
        CardDamage cardDamage = new CardDamage((long) 3, graphicTexture, card);
        return ;
    }
}
