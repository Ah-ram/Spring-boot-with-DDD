package practice.third.graphic_texture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.third.graphic_texture.entity.GraphicTexture;

public interface GraphicTextureRepository extends JpaRepository<GraphicTexture, Long> {
}
