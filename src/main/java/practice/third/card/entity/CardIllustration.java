package practice.third.card.entity;

import jakarta.persistence.*;
import lombok.Getter;
import practice.third.graphic_texture.entity.GraphicTexture;

@Getter
@Entity
public class CardIllustration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "graphic_texture_id", nullable = false)
    private GraphicTexture graphicTexture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", nullable = false)
    private Card card;

    public CardIllustration() {}

    public CardIllustration(GraphicTexture graphicTexture, Card card) {
        this.graphicTexture = graphicTexture;
        this.card = card;
    }
}
