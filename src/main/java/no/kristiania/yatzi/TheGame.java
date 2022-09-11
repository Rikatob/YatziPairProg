package no.kristiania.yatzi;

import java.util.Arrays;

public class TheGame {


    public int[] randomDiceRoll(int numberOfDice) {
        int[] dice = new int[5];

        for (int i = 0; i < numberOfDice; i++) {
            dice[i] = (int)Math.floor((Math.random()*6)+1);
        }
        return dice;
    }


    // MAIN TEST
    public static void main(String[] args) {

        TheGame test = new TheGame();
        System.out.println(Arrays.toString(test.randomDiceRoll(5)));
    }
}
