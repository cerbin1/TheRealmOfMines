package app.game.token;

import app.util.Probability;

public enum TokenColor {
    Green, Purple, Blue, Black, Red;

    public static TokenColor getRandom() {
        return getRandom(new Probability());
    }

    public static TokenColor getRandom(Probability probability) {
        int index = probability.nextInt(0, values().length);
        return values()[index];
    }
}
