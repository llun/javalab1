package dev.llun.poker.ranks;

import dev.llun.poker.Card;
import dev.llun.poker.Hand;
import dev.llun.poker.Result;

import java.util.stream.Collectors;

public class HighHand extends BaseRank {

    public HighHand(Hand hand) {
        super(hand);
    }

    @Override
    public Result equalRankCompare(Rank rank) {
        var cards = getHand().getCards();
        var otherCards = rank.getHand().getCards();
        return compareHighestHandValue(cards.stream().map(Card::value).collect(Collectors.toList()),
                otherCards.stream().map(Card::value).collect(Collectors.toList()));
    }

    @Override
    public Integer value() {
        return 1;
    }
}
