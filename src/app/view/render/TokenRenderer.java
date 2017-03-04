package app.view.render;

import app.view.ImageRepository;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TokenRenderer extends Renderer {
    private final BufferedImage tokenImage;

    public TokenRenderer(TokenVO tokenVO, ImageRepository imageRepository) {
        this(tokenVO, imageRepository.getTokenImage(tokenVO.getColor()));
    }

    private TokenRenderer(TokenVO tokenVO, BufferedImage image) {
        super(tokenVO);
        this.tokenImage = image;
    }

    @Override
    protected void render(Graphics2D graphics) {
        graphics.drawImage(tokenImage, 0, 0, null);
    }
}
