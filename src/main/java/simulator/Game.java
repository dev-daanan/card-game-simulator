package src.main.java.simulator;

import src.main.java.models.Card;
import src.main.java.models.Deck;
import src.main.java.models.Player;
import src.main.java.utilities.InputUtil;

import java.util.ArrayList;

public class Game {
    private final Deck deck;
    private final ArrayList<Player> players;


    public Game(int numPlayers) {
        this.deck = new Deck();
        this.players = new ArrayList<>();

        // Shuffle deck before using it in game
        this.deck.shuffleDeck();

        // Add all players
        for (int i = 1; i <= numPlayers; i++) {
            System.out.println("What is players " + i + "'s name?");
            String name = InputUtil.getStringInput();
            players.add(new Player(name));
        }

        // Choose Game to Start
        String gameChosen = pickGame();

        // Play that game
        switch (gameChosen) {
            case "GoldFish" -> goldFish();
            case "Poker" -> poker();
            case "BlackJack" -> blackjack();
        }
    }

    /**
     * Logic to play GoldFish
     */
    public void goldFish() {
        if (players.size() < 2) {
            System.out.println("not enough players");
            return;
        }
        dealCards();
        boolean isCardsLeftToPlay = true;
        do {
//            try {
//
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid Input");
//            }


            // If all cards have been played
            for (Player currentPlayer : players) {
                goldfishTurn(currentPlayer);

                // Checks if game is Over
                if (deck.getCards().size() < 1) {
                    int playersWithEmptyHands = 0;
                    for (Player player : players) {
                        if (player.getHand().size() < 1) {
                            playersWithEmptyHands++;
                        }
                    }
                    if (playersWithEmptyHands == players.size()) {
                        System.out.println("everyone is out of cards, game is over.");
                        isCardsLeftToPlay = false;
                        break;
                    }
                }
            }
        } while (isCardsLeftToPlay);
        // TODO: 2023-10-10 Create win condition using points

    }

    public void goldfishTurn(Player currentPlayer) {
        System.out.println("Current Turn Belongs to: " + currentPlayer.getName());
        // TODO: 2023-10-10 Change goldfishTurn to auto match pairs dealt to player and give them points accordingly
        Card chosenCard = currentPlayer.chooseCard();
        System.out.println("Which player would you like to ask if they have any " + chosenCard.getValue() + "s");

        Player opponent = chooseOpponent(currentPlayer);
        ArrayList<Card> opponentsHand = opponent.getHand();

        boolean cardMatch = false;
        for (Card opponentsCard : opponentsHand) {
            if (opponentsCard.getValue().equals(chosenCard.getValue())) {
                cardMatch = true;
                currentPlayer.getHand().remove(chosenCard);
                opponentsHand.remove(opponentsCard);
                break;
            }
        }
        if (cardMatch) {
            currentPlayer.changePoints(1);
            // add another card to each player
            dealCard(currentPlayer);
            dealCard(opponent);
            System.out.println("-".repeat(50));
            System.out.println(currentPlayer.getName() + " has increased their points by one. They currently have " + currentPlayer.getPoints() + " points!");
            System.out.println("-".repeat(50));

        } else {
            System.out.println("-".repeat(50));
            System.out.println("Go Fish".repeat(50));
            System.out.println("-".repeat(50));
            dealCard(currentPlayer);
        }

    }


    /**
     * Logic to play poker
     */
    public void poker() {
        System.out.println("Playing poker now");

    }

    /**
     * Logic to play blackjack
     */
    public void blackjack() {
        System.out.println("Playing blackjack now");

    }

    /**
     * Deals cards to each player
     */
    public void dealCards() {
        int cardsPerHand = getNumCardsPerHand();
        System.out.println("Dealing Cards: Started.");
        for (Player player : players) {
            System.out.println("Dealing Cards to player: " + player.getName());
            for (int i = 0; i < cardsPerHand; i++) {
                player.receiveCard(deck.dealCard());
            }
        }
        System.out.println("Dealing Cards: Finished.");
    }


    /**
     * Deals a card to a specified player
     */
    public void dealCard(Player player) {

        System.out.println("Dealing Card to player: " + player.getName());
        player.receiveCard(deck.dealCard());

    }

    public int getNumCardsPerHand() {
        int cardsPerHand = 0;
        do {
            try {

                System.out.println("Please enter the amount of cards you would like to play with per player:");
                cardsPerHand = InputUtil.getIntInput();
                if (cardsPerHand < 1) {
                    System.out.println("Players need more that zero cards... try again.");
                    continue;
                }
                if (players.size() * cardsPerHand > 52) {
                    System.out.println("Not enough cards for this many people... try again.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("invalid input");
                continue;
            }
            break;
        } while (true);
        return cardsPerHand;
    }

    public String pickGame() {
        // Decide game to play
        int gameIndexChosen = 0;
        do {
            try {

                System.out.println("Please enter the index of the game you would like to play:");
                System.out.println("1. GoldFish");
                System.out.println("2. Poker");
                System.out.println("3. BlackJack");
                gameIndexChosen = InputUtil.getIntInput();
                if (gameIndexChosen < 1 || gameIndexChosen > 3) {
                    System.out.println("Input out of range");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("invalid input");
                continue;
            }
            break;
        } while (true);

        String gameChosen = "";
        switch (gameIndexChosen) {
            case 1 -> gameChosen = "GoldFish";
            case 2 -> gameChosen = "Poker";
            case 3 -> gameChosen = "BlackJack";
        }

        return gameChosen;
    }

    public Player chooseOpponent(Player currentPlayer) {
        do {
            int i = 1;

            try {
                for (Player player : players) {
                    System.out.println(i + ". " + player.getName());
                    i++;
                }
                int chosenOpponent = InputUtil.getIntInput() - 1;
                System.out.println();
                if (players.get(chosenOpponent).equals(currentPlayer)) {
                    System.out.println("You cannot chose yourself dumbass...");
                    System.out.println("Try again");
                    continue;
                }
                return players.get(chosenOpponent);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input. Try again");
            }
        } while (true);
    }


}
