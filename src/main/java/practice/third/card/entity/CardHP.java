package practice.third.card.entity;

import jakarta.persistence.*;
import lombok.Getter;
import practice.third.graphic_texture.entity.GraphicTexture;

@Getter
@Entity
public class CardHP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long hp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "graphic_texture_id", nullable = false)
    private GraphicTexture graphicTexture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    public CardHP() {}

    public CardHP(Long hp, GraphicTexture graphicTexture, Card card) {
        this.hp = hp;
        this.graphicTexture = graphicTexture;
        this.card = card;
    }

    public void setHp(Long damage) {
        this.hp = (this.hp <= damage ? 0 : this.hp - damage);
    }
}
