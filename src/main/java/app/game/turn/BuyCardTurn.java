package app.game.turn;

import app.game.Game;
import app.game.Player;
import app.game.card.Card;
import app.game.token.BuyingResult;
import app.game.token.Resources;

public class BuyCardTurn extends Turn {
    private final Card card;

    public BuyCardTurn(Card card) {
        this.card = card;
    }

    @Override
    public void invoke(Game game) {
        Player player = game.getCurrentPlayer();
        Resources resources = player.getResources();
        BuyingResult result = resources.buy(card.getCost());
        if (!result.canBuy()) {
            throw new IllegalTurnException("Not enough resources");
        }
        if (!game.hasCard(card) && !player.hasCard(card)) {
            throw new IllegalTurnException("Card not in game");
        }
        buyCard(game, result);
    }

    private void buyCard(Game game, BuyingResult result) {
        Player player = game.getCurrentPlayer();
        game.setTokens(game.getTokens().add(result.getSpent()));
        player.setTokens(result.getRemaining());
        card.setReserved(false);
        game.removeCard(card);
        player.addCard(card);
    }
}