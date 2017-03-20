package app.view.render;

import app.model.token.Token;
import app.model.token.TokenColor;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class TokenVO extends ViewObject {
    private final Token token;

    public TokenVO(Token token, int x, int y) {
        super(x, y, 122, 122);
        this.token = token;
    }

    @Override
    protected Shape getBaseOutline() {
        return new Ellipse2D.Double(
                getX() - width / 2, getY() - height / 2,
                width, height);
    }

    public TokenColor getColor() {
        return token.getColor();
    }
}
