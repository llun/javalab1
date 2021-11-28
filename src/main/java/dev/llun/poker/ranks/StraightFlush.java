package dev.llun.poker.ranks;

import dev.llun.poker.Card;
import dev.llun.poker.Hand;
import dev.llun.poker.Result;

import java.util.stream.Collectors;

public class StraightFlush extends BaseRank {
    public StraightFlush(Hand hand) {
        super(hand);
    }

    public static Boolean isStraightFlush(Hand hand) {
        return Straight.isStraight(hand) && Flush.isFlush(hand);
    }

    @Override
    Result equalRankCompare(Rank rank) {
        var cards = getHand().getCards();
        var otherCards = rank.getHand().getCards();
        return compareHighestHandValue(cards.stream().map(Card::value).collect(Collectors.toList()), otherCards.stream().map(Card::value).collect(Collectors.toList()));
    }

    @Override
    public Integer value() {
        return 9;
    }
}
