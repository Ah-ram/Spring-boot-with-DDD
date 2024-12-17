package practice.third.graphic_texture.repository;

import practice.third.graphic_texture.entity.GraphicTextureName;

public interface GraphicTextureNameRepository {
    GraphicTextureName getGraphicTextureNameByValue(Long value);
}
