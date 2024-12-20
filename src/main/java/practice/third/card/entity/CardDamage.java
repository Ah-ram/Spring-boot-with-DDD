package practice.third.card.entity;

import jakarta.persistence.*;
import lombok.Getter;
import practice.third.graphic_texture.entity.GraphicTexture;

@Getter
@Entity
public class CardDamage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long damage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "graphic_texture_id", nullable = false)
    private GraphicTexture graphicTexture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    public CardDamage() {}

    public CardDamage(Long damage, GraphicTexture graphicTexture, Card card) {
        this.damage = damage;
        this.graphicTexture = graphicTexture;
        this.card = card;
    }
}
