package practice.third.graphic_texture.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.third.graphic_texture.entity.GraphicTexture;
import practice.third.graphic_texture.entity.GraphicTextureName;
import practice.third.graphic_texture.service.request.GraphicTextureCreateRequest;
import practice.third.graphic_texture.service.response.GraphicTextureCreateResponse;
import practice.third.graphic_texture.repository.GraphicTextureRepository;
import practice.third.graphic_texture.repository.GraphicTextureNameRepository;

@Service
@RequiredArgsConstructor
public class GraphicTextureServiceImpl implements GraphicTextureService {
    private final GraphicTextureRepository graphicTextureRepository;
    private final GraphicTextureNameRepository graphicTextureNameRepository;

    @Override
    public GraphicTextureCreateResponse create(GraphicTextureCreateRequest graphicTextureCreateRequest) {
        Long randomPositiveX = (long)(Math.random() * 200) + 1;
        Long randomPositiveY = (long)(Math.random() * 200) + 1;
        GraphicTextureName graphicTextureName = graphicTextureNameRepository.getGraphicTextureNameByValue(
                graphicTextureCreateRequest.getGraphicTextureKindsNumber());
        GraphicTexture graphicTexture = graphicTextureCreateRequest.toGraphicTexture(
                graphicTextureName,
                randomPositiveX,
                randomPositiveY,
                graphicTextureCreateRequest.getCardNumber());
        GraphicTexture createdGraphicTexture = graphicTextureRepository.save(graphicTexture);

        return GraphicTextureCreateResponse.from(createdGraphicTexture);


    }
}
