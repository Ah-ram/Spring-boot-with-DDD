package practice.third.graphic_texture.service.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.third.graphic_texture.entity.GraphicTexture;
import practice.third.graphic_texture.entity.GraphicTextureName;

@Getter
@RequiredArgsConstructor
public class GraphicTextureCreateRequest {
    private final Long graphicTextureKindsNumber;
    private final Long cardNumber;

    public GraphicTexture toGraphicTexture(
            GraphicTextureName graphicTextureName, Long positionX, Long positionY, Long cardNumber) {
        return new GraphicTexture(
                graphicTextureName,
                positionX,
                positionY,
                cardNumber
        );
    }
}
