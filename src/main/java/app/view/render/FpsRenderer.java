package app.view.render;

import app.model.Updatable;

import java.awt.*;

public class FpsRenderer extends Renderer implements Updatable {
    private int frames = 0;
    private double seconds = 0.0;

    public FpsRenderer(int x, int y) {
        super(new ViewObject(x, y, 100, 50) {
        });
    }

    @Override
    protected void render(Graphics2D graphics) {
        frames++;

        double fps = frames / seconds;
        graphics.setColor(Color.WHITE);
        graphics.drawString(fps + "", 0, 0);
    }

    @Override
    public void update(double secondsPassed) {
        seconds += secondsPassed;
    }

    @Override
    public boolean isHoverable() {
        return false;
    }
}
