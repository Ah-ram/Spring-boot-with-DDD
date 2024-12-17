package practice.third.graphic_texture.controller.response_form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.third.graphic_texture.service.response.GraphicTextureCreateResponse;

@Getter
@RequiredArgsConstructor
public class GraphicTextureCreateResponseForm {
    private final String graphicTextureName;
    private final Long positionX;
    private final Long positionY;

    public static GraphicTextureCreateResponseForm from(GraphicTextureCreateResponse graphicTextureCreateResponse) {
        return new GraphicTextureCreateResponseForm(
                graphicTextureCreateResponse.getGraphicTextureName(),
                graphicTextureCreateResponse.getPositionX(),
                graphicTextureCreateResponse.getPositionY()
        );
    }
}
