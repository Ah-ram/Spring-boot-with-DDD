package practice.third.graphic_texture.service;

import practice.third.graphic_texture.service.request.GraphicTextureCreateRequest;
import practice.third.graphic_texture.service.response.GraphicTextureCreateResponse;

public interface GraphicTextureService {
    GraphicTextureCreateResponse create(GraphicTextureCreateRequest graphicTextureCreateRequest);
}
