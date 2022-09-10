package no.kristiania.yatzi;

import java.util.HashMap;
import java.util.Map;

public class Yatzi {

    private int[] diceRoll;

    public Yatzi(int[] diceRoll) {
        this.diceRoll = diceRoll;
    }


    public int scoreAs(YatziCombination type) {
        int score = 0;

        Map<Integer, Integer> diceCount = new HashMap<>();
        for (int dice : diceRoll) {
            if(!diceCount.containsKey(dice)){
                diceCount.put(dice,1);
            } else {
                diceCount.put(dice,diceCount.get(dice)+1);
            }
        }


        if (type.equals(YatziCombination.CHANCE)) {
            score = 15;
        }
        if (type.equals(YatziCombination.ONES)) {
            score = diceCount.get(1);
        }
        if (type.equals(YatziCombination.TWOS)) {
            score = (diceCount.get(2)*2);
        }
        return score;

    }
}
