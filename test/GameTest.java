import app.game.Game;
import app.game.Player;
import app.game.turn.PassTurn;
import org.junit.Test;

import static app.game.GameBuilder.builder;
import static org.junit.Assert.assertEquals;

public class GameTest {
    @Test
    public void shouldHaveFirstPlayer() {
        // given
        Player player = new Player();
        Game game = builder().add(player).create();

        // when
        Player currentPlayer = game.getCurrentPlayer();

        // then
        assertEquals(player, currentPlayer);
    }

    @Test
    public void shouldChangeCurrentPlayerToNext() {
        // given
        Player second = new Player();
        Game game = builder().add(new Player()).add(second).create();
        game.performTurn(new PassTurn());

        // when
        Player currentPlayer = game.getCurrentPlayer();

        // then
        assertEquals(second, currentPlayer);
    }

    @Test
    public void shouldGetBackToPlayerAfterTwoTurns() {
        // given
        Player first = new Player(), second = new Player();
        Game game = builder().add(first).add(second).create();

        game.performTurn(new PassTurn());
        game.performTurn(new PassTurn());

        // when
        Player currentPlayer = game.getCurrentPlayer();

        // then
        assertEquals(first, currentPlayer);
    }
}
