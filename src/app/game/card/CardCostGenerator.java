package app.game.card;

import app.game.token.Tokens;
import app.util.Probability;

public class CardCostGenerator {
    private final Probability probability;

    CardCostGenerator() {
        this(new Probability());
    }

    public CardCostGenerator(Probability probability) {
        this.probability = probability;
    }

    public Tokens getCheap() {
        return getCost(3, 5);
    }

    public Tokens getMedium() {
        return getCost(5, 8);
    }

    public Tokens getExpensive() {
        return getCost(7, 14);
    }

    private Tokens getCost(int min, int max) {
        int[] array = {0, 0, 0, 0, 0};
        int cost = probability.nextInt(min, max);
        while (cost-- > 0) {
            array[probability.nextInt(0, 5)]++;
        }
        return new Tokens(array[0], array[1], array[2], array[3], array[4]);
    }
}
