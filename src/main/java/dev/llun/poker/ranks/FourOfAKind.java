package dev.llun.poker.ranks;

import dev.llun.poker.Hand;
import dev.llun.poker.Result;

import java.util.stream.Collectors;

public class FourOfAKind extends BaseRank {
    public FourOfAKind(Hand hand) {
        super(hand);
    }

    public static Boolean isFourOfAKind(Hand hand) {
        var handSet = hand.getValueCount();
        return handSet.values().stream().filter(i -> i == 4).count() == 1;
    }

    @Override
    Result equalRankCompare(Rank rank) {
        var handSet = getHand().getValueCount();
        var otherHandSet = rank.getHand().getValueCount();

        var handValue = handSet.keySet().stream().filter(k -> handSet.get(k) == 4).collect(Collectors.toList()).get(0);
        var otherHandValue = otherHandSet.keySet().stream().filter(k -> otherHandSet.get(k) == 4)
                .collect(Collectors.toList()).get(0);

        if (handValue > otherHandValue)
            return Result.WIN;
        if (handValue < otherHandValue)
            return Result.LOSS;

        var theRestOfTheHand = handSet.keySet().stream().filter(k -> handSet.get(k) != 4).collect(Collectors.toList());
        var theRestOfOtherHand = otherHandSet.keySet().stream().filter(k -> otherHandSet.get(k) != 4)
                .collect(Collectors.toList());
        return this.compareHighestHandValue(theRestOfTheHand, theRestOfOtherHand);
    }

    @Override
    public Integer value() {
        return 8;
    }
}
