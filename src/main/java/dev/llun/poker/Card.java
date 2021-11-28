package dev.llun.poker;

public class Card {
    private final String code;
    private final String suit;

    public Card(String value) {
        var parts = value.split("");
        code = parts[0];
        suit = parts[1];
    }

    public String getSuit() {
        return suit;
    }

    public Integer value() {
        return switch (code) {
            case "2", "3", "4", "5", "6", "7", "8", "9" -> Integer.parseInt(code, 10);
            case "T" -> 10;
            case "J" -> 11;
            case "Q" -> 12;
            case "K" -> 13;
            case "A" -> 14;
            default -> -1;
        };
    }

    public String toString() {
        return String.format("%s%s", code, suit);
    }
}
