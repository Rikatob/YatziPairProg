package no.kristiania.yatzi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Yatzi {

    private int[] diceRoll;

    public Yatzi(int[] diceRoll) {
        this.diceRoll = diceRoll;
    }


    public int scoreAs(YatziCombination type) {
        int score = 0;

        Map<Integer, Integer> diceCount = getDiceCount();

        switch (type) {
            case CHANCE -> score = Arrays.stream(diceRoll).sum();
            case ONES -> score = diceCount.get(1);
            case TWOS -> score = (diceCount.get(2) * 2);
            case THREES -> score = (diceCount.get(3) * 3);
            case FOURS -> score = (diceCount.get(4) * 4);
            case FIVES -> score = (diceCount.get(5) * 5);
            case SIXES -> score = (diceCount.get(6) * 6);
            case PAIR -> score = getPairScore(score, diceCount);
            case TWOPAIRS -> {
                score = getTwoPairScore(score, diceCount);
            }
        }

        return score;

    }

    private Map<Integer, Integer> getDiceCount() {
        Map<Integer, Integer> diceCount = new HashMap<>();
        for (int dice : diceRoll) {
            if (!diceCount.containsKey(dice)) {
                diceCount.put(dice, 1);
            } else {
                diceCount.put(dice, diceCount.get(dice) + 1);
            }
        }
        return diceCount;
    }

    private int getPairScore(int score, Map<Integer, Integer> diceCount) {

        for (int key : diceCount.keySet()) {
            if (diceCount.get(key) >= 2) {
                if ((key * 2) > score) {
                    score = key * 2;
                }
            }
        }
        return score;
    }


    private static int getTwoPairScore(int score, Map<Integer, Integer> diceCount) {
        for (Integer key : diceCount.keySet()) {
            if (diceCount.get(key) >= 2) {
                score += key;
            }
        }
        return score * 2;
    }
}
