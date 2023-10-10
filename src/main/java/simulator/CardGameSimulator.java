package src.main.java.simulator;

import src.main.java.models.Deck;
import src.main.java.models.Player;

// note: Only Goldfish is implemented
// TODO: 2023-10-10 Ensure proper testing is done on all classes.
public class CardGameSimulator {
    public static void main(String[] args) {
        Deck myDeck = new Deck();
//        myDeck.printDeck();
        System.out.println("_".repeat(50));
        myDeck.shuffleDeck();
//        myDeck.printDeck();

        Player daanan = new Player("Daanan");
        for (int i = 0; i < 5; i++) {
            daanan.receiveCard(myDeck.dealCard());
        }
        Game goldfishGame = new Game(2);

    }
}
