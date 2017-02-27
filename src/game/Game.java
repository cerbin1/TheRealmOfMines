package game;

import game.cards.Card;

import java.util.List;
import java.util.Random;

public class Game {
    private Tokens tokens;
    private List<Card> cheapCards;
    private List<Card> mediumCards;
    private List<Card> expensiveCards;
    private List<Player> players;
    private int currentPlayer = 0;

    Game(Tokens tokens, List<Player> players, List<Card> cheapCards, List<Card> mediumCards, List<Card> expensiveCards) {
        this.players = players;
        this.tokens = tokens;
        this.cheapCards = cheapCards;
        this.mediumCards = mediumCards;
        this.expensiveCards = expensiveCards;
    }

    private void startGame() {
        currentPlayer = drawPlayer();
    }

    private int drawPlayer() {
        return new Random().nextInt(players.size());
    }

    public Tokens getTokens() {
        return tokens;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    public List<Card> getCheapCards() {
        return cheapCards;
    }

    public List<Card> getMediumCards() {
        return mediumCards;
    }

    public List<Card> getExpensiveCards() {
        return expensiveCards;
    }

    public static void main(String[] args) {
        new GameFactory().create();
    }
}
