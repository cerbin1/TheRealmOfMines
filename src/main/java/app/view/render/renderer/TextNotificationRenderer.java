package app.view.render.renderer;

import app.model.Updatable;
import app.view.render.vo.ViewObject;

import java.awt.*;

public class TextNotificationRenderer extends Renderer implements Updatable {
    private final String text;
    private double seconds;
    private double timer = 0;

    public TextNotificationRenderer(String text, int x, int y) {
        super(new ViewObject(x, y, 300, 50) {
        });
        this.text = text;
        this.seconds = 3;
    }

    public TextNotificationRenderer(String text, int seconds, int x, int y) {
        super(new ViewObject(x, y, 300, 50) {
        });
        this.text = text;
        this.seconds = seconds;
    }

    @Override
    protected void render(Graphics2D graphics) {
        if (timer < seconds) {
            System.out.println(timer);
            graphics.drawString(text, 30, 30);
        }
    }

    @Override
    public void update(double secondsPassed) {
        timer += secondsPassed;
    }
}
