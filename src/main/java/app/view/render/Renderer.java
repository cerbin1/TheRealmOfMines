package app.view.render;

import app.view.render.vo.ViewObject;
import app.view.util.Resolution;

import java.awt.*;
import java.awt.geom.AffineTransform;

public abstract class Renderer {
    final ViewObject viewObject;

    Renderer(ViewObject viewObject) {
        this.viewObject = viewObject;
    }

    protected abstract void render(Graphics2D graphics);

    public void renderOn(Graphics2D graphics2D) {
        AffineTransform previous = graphics2D.getTransform();
        graphics2D.setTransform(getTransform());
        render(graphics2D);
        graphics2D.setTransform(previous);
    }

    private AffineTransform getTransform() {
        AffineTransform transform = new AffineTransform();
        transform.scale(0.6, 0.6);
        Resolution.scaleFullHdToResolution(transform);
        transform.translate(viewObject.getX(), viewObject.getY());
        transform.scale(viewObject.getPerspectiveX(), viewObject.getPerspectiveY());
        transform.rotate(viewObject.getRotation());
        transform.translate(-viewObject.getWidth() / 2, -viewObject.getHeight() / 2);
        return transform;
    }

    private void drawOutline(Graphics2D graphics2D) {
        graphics2D.setStroke(new BasicStroke(1));
        graphics2D.setColor(Color.red);
        graphics2D.draw(viewObject.getOutline());
    }

    public ViewObject getViewObject() {
        return viewObject;
    }

    public boolean isHoverable() {
        return true;
    }
}
