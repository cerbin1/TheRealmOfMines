package app.game.turn;

import app.game.Game;
import app.game.Player;
import app.game.card.Card;
import app.game.token.Resources;
import app.game.token.Tokens;

public class BuyCardTurn extends Turn {
    private final Card card;

    public BuyCardTurn(Card card) {
        this.card = card;
    }

    @Override
    public void invoke(Game game) {
        Player player = game.getCurrentPlayer();
        Resources resources = player.getResourcesNEW();
        Tokens cardCost = card.getCost();
        if (!resources.canBuy(cardCost) || !game.getAvailableCards().contains(card) && !player.getCards().contains(card)) {
            throw new IllegalTurnException();
        } else {
            Tokens tokensSpent = player.getTokens().subtract(resources.calculateChange(cardCost));
            game.setTokens(game.getTokens().add(tokensSpent));
            player.setTokens(resources.calculateChange(cardCost));
            card.setReserved(false);
            game.removeCard(card);
            player.addCard(card);
        }
    }
}
