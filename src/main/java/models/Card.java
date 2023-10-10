package src.main.java.models;

import src.main.java.enums.CardType;
import src.main.java.enums.CardValue;

public class Card {
    private final CardType type;
    private final CardValue value;

    public Card(CardType type, CardValue value) {
        this.type = type;
        this.value = value;
    }


    @Override
    public String toString() {
        return "Card { " + value + " of " + type + " }";
    }

    public CardType getType() {
        return type;
    }

    public CardValue getValue() {
        return value;
    }


}
