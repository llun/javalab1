package dev.llun.poker.ranks;

import dev.llun.poker.Hand;
import dev.llun.poker.Result;

import java.util.stream.Collectors;

public class TwoPair extends BaseRank {
    public TwoPair(Hand hand) {
        super(hand);
    }

    public static Boolean isTwoPair(Hand hand) {
        return hand.getValueCount().values().stream().filter(i -> i == 2).count() == 2;
    }

    @Override
    Result equalRankCompare(Rank rank) {
        var handValues = getHand().getValueCount();
        var otherHandValues = rank.getHand().getValueCount();

        var handPairs = handValues.keySet().stream().filter(k -> handValues.get(k) == 2).collect(Collectors.toList());
        var otherHandPairs = otherHandValues.keySet().stream().filter(k -> otherHandValues.get(k) == 2).collect(Collectors.toList());

        var pairResult = compareHighestHandValue(handPairs, otherHandPairs);
        if (pairResult != Result.TIE) return pairResult;

        var handNonPair = handValues.keySet().stream().filter(k -> handValues.get(k) == 1).collect(Collectors.toList());
        var otherHandNonPair = otherHandValues.keySet().stream().filter(k -> otherHandValues.get(k) == 1).collect(Collectors.toList());
        return compareHighestHandValue(handNonPair, otherHandNonPair);
    }

    @Override
    public Integer value() {
        return 3;
    }
}
