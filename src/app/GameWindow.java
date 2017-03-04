package app;

import app.game.Updatable;
import app.game.card.CheapCard;
import app.game.token.Token;
import app.view.ImageRepository;
import app.view.Window;
import app.view.render.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import static app.game.token.TokenColor.Green;
import static java.awt.RenderingHints.*;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class GameWindow implements Updatable {
    private final Window window = new Window();
    private ImageRepository imageRepository = new ImageRepository();

    private List<Updatable> updatables = new ArrayList<>();
    private List<Renderer> renderers = new ArrayList<>();

    private Graphics windowGraphics;
    private BufferedImage backBuffer;
    private Graphics2D canvas;

    GameWindow() {
        initializeBackBuffer();
        initializeGame();
    }

    private void initializeBackBuffer() {
        backBuffer = new BufferedImage(1920, 1080, TYPE_INT_ARGB);
        canvas = backBuffer.createGraphics();
        canvas.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        canvas.setRenderingHint(KEY_RENDERING, VALUE_RENDER_QUALITY);
    }

    private void initializeGame() {
        CardVO cardVO = new CardVO(new CheapCard(), 500, 300);
        cardVO.setRotation(CardVO.randomCardRotation());

        TokenVO tokenVO = new TokenVO(1000, 500, new Token(Green));
        tokenVO.moveTo(500, 700, 1.5);
        tokenVO.setRotation(0.1);

        TokenVO versatileVO = new TokenVO(1100, 550, new Token(null));

        updatables.add(cardVO);
        updatables.add(tokenVO);

        renderers.add(new BackgroundRenderer(imageRepository));
        renderers.add(new CardRenderer(cardVO, imageRepository));
        renderers.add(new TokenRenderer(tokenVO, imageRepository));
        renderers.add(new TokenRenderer(versatileVO, imageRepository));
    }

    public void update(double secondsElapsed) {
        updatables.forEach(updatable -> updatable.update(secondsElapsed));
    }

    public void render() {
        renderers.forEach(renderer -> renderer.renderOn(canvas));
        windowGraphics.drawImage(backBuffer, 0, 0, null);
    }

    void show() {
        window.show();
        windowGraphics = window.getGraphics();
    }
}
