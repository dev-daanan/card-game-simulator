package src.main.java.models;

import src.main.java.enums.CardType;
import src.main.java.enums.CardValue;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards;

    // CONSTRUCTORS
    public Deck() {
        cards = new ArrayList<>();
        for (CardType cardType : CardType.values()) {
            for (CardValue cardValue : CardValue.values()) {
                Card newCard = new Card(cardType, cardValue);
                cards.add(newCard);
            }
        }
    }

    // METHODS
    // method for shuffling
    public void shuffleDeck() {
        ArrayList<Card> shuffledDeck = new ArrayList<>();
        Random random = new Random();
        int randomCardIndex = -1;
        Card randomCard = null;
        int deckSize = cards.size();
        for (int i = 0; i < 52; i++) {
            randomCardIndex = random.nextInt(cards.size());
            randomCard = cards.get(randomCardIndex);
            cards.remove(randomCardIndex);
            shuffledDeck.add(randomCard);
        }
        this.cards = shuffledDeck;
    }

    /**
     * Deals and removes most top card in deck.
     * Returns: Card
     */
    public Card dealCard() {
        return this.cards.remove(cards.size() -1);
    }


    /**
     * Prints Deck in Order
     */
    public void printDeck() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    // GETTERS AND SETTERS
    public ArrayList<Card> getCards() {
        return cards;
    }
}
