package no.kristiania.yatzi;

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

        Map<Integer, Integer> diceCount = new HashMap<>();
        for (int dice : diceRoll) {
            if (!diceCount.containsKey(dice)) {
                diceCount.put(dice, 1);
            } else {
                diceCount.put(dice, diceCount.get(dice) + 1);
            }
        }

        if (type.equals(YatziCombination.CHANCE)) {
            score = 15;
        }
        if (type.equals(YatziCombination.ONES)) {
            score = diceCount.get(1);
        }
        if (type.equals(YatziCombination.TWOS)) {
            score = (diceCount.get(2) * 2);
        }
        if (type.equals(YatziCombination.THREES)) {
            score = (diceCount.get(3) * 3);
        }
        if (type.equals(YatziCombination.PAIR)) {

            for (int key : diceCount.keySet()) {
                if (diceCount.get(key) >= 2) {
                    if ((key * 2) > score) {
                        score = key * 2;

                    }

                }
            }

        }


        return score;

    }
}
