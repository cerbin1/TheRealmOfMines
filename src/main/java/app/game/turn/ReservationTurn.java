package app.game.turn;

import app.game.Game;
import app.game.Player;
import app.game.card.Card;

public class ReservationTurn extends Turn {
    private Card card;

    public ReservationTurn(Card card) {
        this.card = card;
    }

    @Override
    public void invoke(Game game) {
        Player player = game.getCurrentPlayer();
        if (player.hasCard(card)) {
            throw new IllegalTurnException("Card is already possessed by player");
        }
        if (!game.hasCard(card)) {
            throw new IllegalTurnException("Card is not available in game");
        }
        if (card.isReserved()) {
            throw new IllegalTurnException("Card already reserved");
        }
        if (game.getTokens().getVersatile() >= 1) {
            player.incVersatile(1);
            game.decVersatile(1);
        }
        card.setReserved(true);
        game.removeCard(card);
        player.addCard(card);
    }
}