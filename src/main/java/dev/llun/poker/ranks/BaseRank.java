package dev.llun.poker.ranks;

import dev.llun.poker.Hand;
import dev.llun.poker.Result;

import java.util.List;

public abstract class BaseRank implements Rank {
    private final Hand hand;

    public BaseRank(Hand hand) {
        this.hand = hand;
    }

    public Hand getHand() {
        return hand;
    }

    public Result compare(Rank rank) {
        if (value() > rank.value())
            return Result.WIN;
        if (value() < rank.value())
            return Result.LOSS;
        return equalRankCompare(rank);
    }

    abstract Result equalRankCompare(Rank rank);

    Result compareHighestHandValue(List<Integer> cards1, List<Integer> cards2) {
        for (int i = cards1.size() - 1; i >= 0; i--) {
            if (cards1.get(i) > cards2.get(i))
                return Result.WIN;
            else if (cards1.get(i) < cards2.get(i))
                return Result.LOSS;
        }
        return Result.TIE;
    }
}
