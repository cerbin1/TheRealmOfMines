package app.game;

import app.game.card.Card;

import java.util.ArrayList;
import java.util.List;

public class GameBuilder {
    private Tokens tokens;
    private List<Player> players = new ArrayList<>();
    private List<Card> cheapCards = new ArrayList<>();
    private List<Card> mediumCards = new ArrayList<>();
    private List<Card> expensiveCards = new ArrayList<>();

    public Game create() {
        return new Game(tokens, players, cheapCards, mediumCards, expensiveCards);
    }

    public void setTokens(Tokens tokens) {
        this.tokens = tokens;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addCheapCard(Card cheapCard) {
        cheapCards.add(cheapCard);
    }

    public void addMediumCard(Card mediumCard) {
        mediumCards.add(mediumCard);
    }

    public void addExpensiveCard(Card expensiveCard) {
        expensiveCards.add(expensiveCard);
    }
}