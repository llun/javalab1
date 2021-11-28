package dev.llun.poker.ranks;

import dev.llun.poker.Card;
import dev.llun.poker.Hand;
import dev.llun.poker.Result;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Straight extends BaseRank {
    public Straight(Hand hand) {
        super(hand);
    }

    public static Boolean isStraight(Hand hand) {
        var cards = hand.getCards();
        var result = cards.stream().map(Card::value).collect(
                ArrayList<Integer[]>::new,
                (list, value) -> {
                    if (list.size() == 0) list.add(new Integer[]{value, 1});
                    else list.add(new Integer[]{value, value - list.get(list.size() - 1)[0]});
                },
                ArrayList::addAll
        );
        return result.stream().map(record -> record[1]).allMatch(diff -> diff == 1);
    }

    @Override
    public Result equalRankCompare(Rank rank) {
        var cards = getHand().getCards();
        var otherCards = rank.getHand().getCards();
        return compareHighestHandValue(cards.stream().map(Card::value).collect(Collectors.toList()), otherCards.stream().map(Card::value).collect(Collectors.toList()));
    }

    @Override
    public Integer value() {
        return 5;
    }
}
