package dev.llun.poker.ranks;

import dev.llun.poker.Hand;

public class FullHouse extends ThreeOfAKind {
    public FullHouse(Hand hand) {
        super(hand);
    }

    public static Boolean isFullHouse(Hand hand) {
        var handValues = hand.getValueCount().values();
        return handValues.stream().filter(i -> i == 3).count() == 1
                && handValues.stream().filter(i -> i == 2).count() == 1;
    }

    @Override
    public Integer value() {
        return 7;
    }
}
