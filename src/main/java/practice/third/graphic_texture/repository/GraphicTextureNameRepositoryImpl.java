package practice.third.graphic_texture.repository;

import org.springframework.stereotype.Repository;
import practice.third.graphic_texture.entity.GraphicTextureName;

@Repository
public class GraphicTextureNameRepositoryImpl implements GraphicTextureNameRepository{
    @Override
    public GraphicTextureName getGraphicTextureNameByValue(Long value) {
        return GraphicTextureName.getGraphicTextureNameByValue(value);
    }
}
