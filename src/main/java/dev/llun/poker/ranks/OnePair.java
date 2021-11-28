package dev.llun.poker.ranks;

import dev.llun.poker.Hand;
import dev.llun.poker.Result;

import java.util.stream.Collectors;

public class OnePair extends BaseRank {
    public OnePair(Hand hand) {
        super(hand);
    }

    public static Boolean isOnePair(Hand hand) {
        return hand.getValueCount().values().stream().filter(i -> i == 2).count() == 1;
    }

    @Override
    Result equalRankCompare(Rank rank) {
        var valueSet = getHand().getValueCount();
        var otherValueSet = rank.getHand().getValueCount();

        Integer handValue = valueSet.keySet().stream().filter(k -> valueSet.get(k) == 2).collect(Collectors.toList()).get(0);
        Integer otherHandValue = otherValueSet.keySet().stream().filter(k -> otherValueSet.get(k) == 2).collect(Collectors.toList()).get(0);
        if (handValue > otherHandValue) return Result.WIN;
        if (handValue < otherHandValue) return Result.LOSS;

        var theRestOfTheHand = valueSet.keySet().stream().filter(k -> valueSet.get(k) != handValue).collect(Collectors.toList());
        var theRestOfOtherHand = otherValueSet.keySet().stream().filter(k -> otherValueSet.get(k) != otherHandValue).collect(Collectors.toList());
        return this.compareHighestHandValue(theRestOfTheHand, theRestOfOtherHand);
    }

    @Override
    public Integer value() {
        return 2;
    }
}
