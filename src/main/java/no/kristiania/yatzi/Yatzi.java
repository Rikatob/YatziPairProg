package no.kristiania.yatzi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Yatzi {

    private int[] diceRoll;

    public Yatzi(int[] diceRoll) {
        this.diceRoll = diceRoll;
    }



    /***
     *
     * @param type enum YatziCombination
     * @return int of the total score for given game
     */
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
            case PAIR -> score = getPairScore(diceCount);
            case TWOPAIRS -> score = getTwoPairScore(diceCount);

        }

        return score;

    }


    /***
     *
     * @return Map of the frequency of the dice
     *
     * -> Uses one diceRoll to put the dice in a hashmap with key/value as integers.
     * -> key = The dice type <---> value = The number of times the dice occur.
     */
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


    /***
     *
     * @param diceCount Map of the frequency of the dice
     * @return int of the score from the highest pair value
     *
     *  -> Goes through every key (diceType)
     *      -> Checks if the value (times the dice occur) is equal or more than 2 (one or more pair)
     *      -> Add the right score for the first pair found in the map.
     *          -> Then checks if pair occur more than once
     *             and if it does it change score value to the highest possible.
     */
    private int getPairScore(Map<Integer, Integer> diceCount) {

        int score = 0;
        for (int key : diceCount.keySet()) {
            if (diceCount.get(key) >= 2) {
                if ((key * 2) > score) {
                    score = key * 2;
                }
            }
        }
        return score;
    }



    /***
     *
     * @param diceCount Map of the frequency of the dice
     * @return int of the score from the highest pair value
     *
     * -> Does the same as getPairScore(), but just add the key (type of dice) to score.
     * -> Multiply the score with two to get the right score.
     * -> (key <--> value)
     *      -> (1 <--> 2), (4 <--> 2), (6 <--> 1)
     *          -> two pairs
     *              -> score = (1 + 4) * 2
     */
    private static int getTwoPairScore(Map<Integer, Integer> diceCount) {
        int score = 0;
        for (Integer key : diceCount.keySet()) {
            if (diceCount.get(key) >= 2) {
                score += key * 2;
            }
        }
        return score;
    }
}
