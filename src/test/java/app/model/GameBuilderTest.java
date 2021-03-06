package app.model;

import app.model.card.Card;
import app.model.card.CheapCard;
import app.model.card.nobility.Nobility;
import app.model.token.TokensAmount;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class GameBuilderTest {
    @Test
    public void shouldSetTokens() {
        // given
        GameBuilder builder = new GameBuilder();
        TokensAmount tokensAmount = new TokensAmount();

        // when
        Game game = builder.set(tokensAmount).add(new Player()).create();

        // then
        assertEquals(game.getTokensAmount(), tokensAmount);
    }

    @Test
    public void shouldAddPlayer() {
        // given
        GameBuilder builder = new GameBuilder();
        Player first = new Player(), second = new Player();

        // when
        Game game = builder.add(first).add(second).create();

        // then
        assertEquals(game.getPlayers(), asList(first, second));
        assertEquals(game.getCurrentPlayer(), first);
    }

    @Test
    public void shouldAddCard() {
        // given
        GameBuilder builder = new GameBuilder();
        Card first = new CheapCard(), second = new CheapCard();

        // when
        Game game = builder.add(first).add(second).add(new Player()).create();

        // then
        assertEquals(game.getAvailableCards(), asList(first, second));
    }

    @Test
    public void shouldAddNobility() {
        // given
        GameBuilder builder = new GameBuilder();
        Nobility first = new Nobility(new TokensAmount(), 4),
                second = new Nobility(new TokensAmount(), 3);

        // when
        Game game = builder.add(first).add(second).add(new Player()).create();

        // then
        assertEquals(game.getNobilities(), asList(first, second));
    }
}
