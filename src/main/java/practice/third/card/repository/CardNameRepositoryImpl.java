package practice.third.card.repository;

import org.springframework.stereotype.Repository;
import practice.third.card.entity.CardName;

@Repository
public class CardNameRepositoryImpl implements CardNameRepository {
    @Override
    public CardName getCardNameByValue(Long value) {
        return CardName.getCardNameByValue(value);
    }
}
