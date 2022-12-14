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
            case ONES -> score = getSinglesScore(diceCount, 1);
            case TWOS -> score = getSinglesScore(diceCount, 2);
            case THREES -> score = getSinglesScore(diceCount, 3);
            case FOURS -> score = getSinglesScore(diceCount, 4);
            case FIVES -> score = getSinglesScore(diceCount, 5);
            case SIXES -> score = getSinglesScore(diceCount, 6);
            case PAIR -> score = getOfAKindScore(2, diceCount);
            case TWOPAIRS -> score = getTwoPairScore(diceCount);
            case THREEOFAKIND -> score = getOfAKindScore(3, diceCount);
            case FOUROFAKIND -> score = getOfAKindScore(4, diceCount);
            case SMALLSTRAIGHT, BIGSTRAIGHT -> score = getStraightScore(diceCount);
            case FULLHOUSE -> score = getFullHouseScore(diceCount);
            case CHANCE -> score = Arrays.stream(diceRoll).sum();
            case YATZI -> score = getYatziScore(diceCount);

        }

        return score;

    }

    private int getYatziScore(Map<Integer, Integer> diceCount) {
        int score = 0;

        for (Integer key : diceCount.keySet()) {
            if (diceCount.get(key) == 5) {
                score = 50;
            }
        }
        return score;
    }

    /***
     *
     * @param diceCount Map of the frequency of the dice
     * @param diceType Type of yatzi game
     * @return total score for all singles of one dice as int
     */
    private int getSinglesScore(Map<Integer, Integer> diceCount, int diceType) {
        int score = 0;
        if (!diceCount.containsKey(diceType)) {
            return score;
        } else {
            score = diceCount.get(diceType) * diceType;
        }
        return score;
    }

    private int getOfAKindScore(int amount, Map<Integer, Integer> diceCount) {
        int score = 0;


        for (int dice : diceCount.keySet()) {
            if (diceCount.get(dice) >= amount) {
                score = dice * amount;
            }
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


    /***
     *
     * @param diceCount Map of the frequency of the dice
     * @return Score 20 if its big and 15 if its small
     */
    private int getStraightScore(Map<Integer, Integer> diceCount) {
        int score = 0;
        int keysCombinedValue = 0;

        //Likte na her. va smooth
        for (Integer key : diceCount.keySet()) {
            keysCombinedValue += key;
        }
        if (keysCombinedValue == 15) {
            score = 15;
        }
        if (keysCombinedValue == 20) {
            score = 20;
        }
        return score;
    }

    private int getFullHouseScore(Map<Integer, Integer> diceCount) {
        int score = 0;
        boolean pair = false;
        boolean triumvirate = false;
        for (Integer key : diceCount.keySet()) {
            if (diceCount.get(key) == 2) {
                score += key * 2;
                pair = true;
            }
            if (diceCount.get(key) == 3) {
                score += key * 3;
                triumvirate = true;
            }
        }

        if (!(triumvirate && pair)) {
            return 0;
        }
        return score;
    }
}
