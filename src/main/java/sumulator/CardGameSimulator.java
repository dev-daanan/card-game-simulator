package src.main.java.sumulator;

import src.main.java.models.Card;
import src.main.java.models.Deck;

public class CardGameSimulator {
    public static void main(String[] args) {
        Deck myDeck = new Deck();
        for (Card card : myDeck.getDeck()) {
            System.out.println(card);
        }
    }
}
