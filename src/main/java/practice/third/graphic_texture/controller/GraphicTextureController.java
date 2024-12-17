package practice.third.graphic_texture.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import practice.third.graphic_texture.controller.request_form.GraphicTextureCreateRequestForm;
import practice.third.graphic_texture.controller.response_form.GraphicTextureCreateResponseForm;
import practice.third.graphic_texture.service.GraphicTextureService;
import practice.third.graphic_texture.service.response.GraphicTextureCreateResponse;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/graphic-texture")
public class GraphicTextureController {
    private final GraphicTextureService graphicTextureService;

    @PostMapping("/create")
    public GraphicTextureCreateResponseForm createGraphicTexture(
            @RequestBody GraphicTextureCreateRequestForm graphicTextureCreateRequestForm) {
        log.info("graphic texture controller -> createGraphicTexture() called!");

        GraphicTextureCreateResponse response = graphicTextureService.create(
                graphicTextureCreateRequestForm.toGraphicTextureCreateRequest());

        return GraphicTextureCreateResponseForm.from(response);
    }

}
