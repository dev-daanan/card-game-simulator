package src.main.java.models;

import src.main.java.enums.CardType;
import src.main.java.enums.CardValue;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        for (CardType cardType : CardType.values()) {
            for (CardValue cardValue : CardValue.values()) {
                Card newCard = new Card(cardType, cardValue);
                deck.add(newCard);
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }
}
