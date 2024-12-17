package practice.third.graphic_texture.controller.request_form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.third.graphic_texture.service.request.GraphicTextureCreateRequest;

@Getter
@RequiredArgsConstructor
public class GraphicTextureCreateRequestForm {
    private final Long graphicTextureKindsNumber;
    private final Long cardNumber;

    public GraphicTextureCreateRequest toGraphicTextureCreateRequest() {
        return new GraphicTextureCreateRequest(this.graphicTextureKindsNumber, this.cardNumber);
    }
}
