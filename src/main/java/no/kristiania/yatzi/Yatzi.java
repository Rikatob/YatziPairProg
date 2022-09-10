package no.kristiania.yatzi;

public class Yatzi {
    public Yatzi(int[] diceRoll) {
    }


    public int scoreAs(YatziCombination type) {
        int score = 0;

        if (type.equals(YatziCombination.CHANCE)) {
            score = 15;
        }
        if (type.equals(YatziCombination.ONES)) {
            score = 2;
        }
        if (type.equals(YatziCombination.TWOS)) {
            score = 4;
        }
        return score;

    }
}
