package dev.llun.poker.ranks;

import dev.llun.poker.Hand;
import dev.llun.poker.Result;

import java.util.stream.Collectors;

public class ThreeOfAKind extends BaseRank {
    public ThreeOfAKind(Hand hand) {
        super(hand);
    }

    public static Boolean isThreeOfAKind(Hand hand) {
        return hand.getValueCount().values().stream().filter(i -> i == 3).count() == 1;
    }

    @Override
    Result equalRankCompare(Rank rank) {
        var handSet = getHand().getValueCount();
        var otherSet = rank.getHand().getValueCount();

        var handValue = handSet.keySet().stream().filter(k -> handSet.get(k) == 3).collect(Collectors.toList()).get(0);
        var otherHandValue = otherSet.keySet().stream().filter(k -> otherSet.get(k) == 3).collect(Collectors.toList()).get(0);

        if (handValue > otherHandValue) return Result.WIN;
        if (handValue < otherHandValue) return Result.LOSS;

        var theRestOfTheHand = handSet.keySet().stream().filter(k -> handSet.get(k) != 3).collect(Collectors.toList());
        var theRestOfOtherHand = otherSet.keySet().stream().filter(k -> otherSet.get(k) != 3).collect(Collectors.toList());
        return this.compareHighestHandValue(theRestOfTheHand, theRestOfOtherHand);
    }

    @Override
    public Integer value() {
        return 4;
    }
}
