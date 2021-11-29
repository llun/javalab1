package dev.llun.poker.ranks;

import dev.llun.poker.Hand;
import dev.llun.poker.Result;

public interface Rank {
    static Rank fromHand(Hand hand) {
        if (StraightFlush.isStraightFlush(hand))
            return new StraightFlush(hand);
        if (FourOfAKind.isFourOfAKind(hand))
            return new FourOfAKind(hand);
        if (FullHouse.isFullHouse(hand))
            return new FullHouse(hand);
        if (Flush.isFlush(hand))
            return new Flush(hand);
        if (Straight.isStraight(hand))
            return new Straight(hand);
        if (ThreeOfAKind.isThreeOfAKind(hand))
            return new ThreeOfAKind(hand);
        if (TwoPair.isTwoPair(hand))
            return new TwoPair(hand);
        if (OnePair.isOnePair(hand))
            return new OnePair(hand);
        return new HighHand(hand);
    }

    Hand getHand();

    Result compare(Rank rank);

    Integer value();
}
