package src.main.java.models;

import src.main.java.utilities.InputUtil;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private int points;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.points = 0;
    }

    /**
     * Adds a card to players' hand.
     */
    public void receiveCard(Card card) {
        hand.add(card);
    }

    /**
     * Has player pick card to present. Does NOT remove card from players' hand.
     */
    public Card chooseCard() {
        if (hand.size() < 1) return null;
        int position = 1;

        do {
            try {

                System.out.println("Enter index of card to choose: 1 - " + hand.size());
                for (Card card : hand) {
                    System.out.println(position + ". " + card);
                    position++;
                }

                int chosenCardIndex = InputUtil.getIntInput() - 1;
                return hand.get(chosenCardIndex);
            } catch (InputMismatchException e) {
                System.out.println("invalid input");
            }

        } while (true);
    }

    /**
     * Prints hand
     */
    public void printHand() {
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    public void changePoints(int differenceInPoints) {
        this.points = this.points + differenceInPoints;
    }

    // GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }


    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
