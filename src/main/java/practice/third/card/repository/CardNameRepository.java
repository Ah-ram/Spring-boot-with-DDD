package practice.third.card.repository;

import practice.third.card.entity.CardName;

public interface CardNameRepository {
    CardName getCardNameByValue(Long value);
}
