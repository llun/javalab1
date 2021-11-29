package dev.llun.poker;

import dev.llun.poker.ranks.Rank;

import java.util.*;
import java.util.stream.Collectors;

public class Hand {
    private final List<Card> cards;
    private final Map<Integer, Integer> valueCount;

    public Hand(String hand) {
        cards = Arrays.stream(hand.split(" ")).map(Card::new).collect(Collectors.toList());
        cards.sort(Comparator.comparingInt(Card::value));

        valueCount = cards.stream().mapToInt(Card::value).collect(HashMap::new, (map, value) -> {
            if (map.containsKey(value))
                map.put(value, map.get(value) + 1);
            else
                map.put(value, 1);
        }, HashMap::putAll);
    }

    public List<Card> getCards() {
        return cards;
    }

    public Map<Integer, Integer> getValueCount() {
        return valueCount;
    }

    public Result compareWith(Hand hand) {
        var handRank = Rank.fromHand(this);
        var otherRank = Rank.fromHand(hand);
        return handRank.compare(otherRank);
    }
}
