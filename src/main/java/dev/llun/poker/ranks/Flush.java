package dev.llun.poker.ranks;

import dev.llun.poker.Card;
import dev.llun.poker.Hand;
import dev.llun.poker.Result;

import java.util.stream.Collectors;

public class Flush extends BaseRank {
    public Flush(Hand hand) {
        super(hand);
    }

    public static Boolean isFlush(Hand hand) {
        var cards = hand.getCards();
        return cards.stream().map(Card::getSuit).collect(Collectors.toSet()).size() == 1;
    }

    @Override
    Result equalRankCompare(Rank rank) {
        var cards = getHand().getCards();
        var otherCards = rank.getHand().getCards();
        return compareHighestHandValue(cards.stream().map(Card::value).collect(Collectors.toList()), otherCards.stream().map(Card::value).collect(Collectors.toList()));
    }

    @Override
    public Integer value() {
        return 6;
    }
}
