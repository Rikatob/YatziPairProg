package no.kristiania.yatzi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatziTest {

    @Test
    void shouldScoreOnesTest(){
        var yatziGame = new Yatzi(new int[]{
                1,2,1,4,5
        });
        assertEquals(1+1,yatziGame.scoreAs(YatziCombination.ONES));

        // FAIL
        yatziGame = new Yatzi(new int[]{
                3,2,4,4,5
        });
        assertEquals(0,yatziGame.scoreAs(YatziCombination.ONES));
    }

    @Test
    void shouldScoreTwosTest(){
        var yatziGame = new Yatzi(new int[]{
                1,2,3,2,5
        });
        assertEquals(4,yatziGame.scoreAs(YatziCombination.TWOS));

        // FAIL
        yatziGame = new Yatzi(new int[]{
                3,3,4,4,5
        });
        assertEquals(0,yatziGame.scoreAs(YatziCombination.TWOS));
    }

    @Test
    void shouldScoreThreesTest(){
        var yatziGame = new Yatzi(new int[]{
                3,3,3,2,5
        });
        assertEquals(9,yatziGame.scoreAs(YatziCombination.THREES));

        // FAIL
        yatziGame = new Yatzi(new int[]{
                6,2,4,4,5
        });
        assertEquals(0,yatziGame.scoreAs(YatziCombination.THREES));
    }


    @Test
    void shouldScorePairTest(){
        var yatziGame = new Yatzi(new int[]{
                1,2,2,4,5
        });
        assertEquals(4,yatziGame.scoreAs(YatziCombination.PAIR));

        // FAIL
        yatziGame = new Yatzi(new int[]{
                6,2,1,4,5
        });
        assertEquals(0,yatziGame.scoreAs(YatziCombination.PAIR));

    }

    @Test
    void shouldScoreTheHighestPairTest(){
        var yatziGame = new Yatzi(new int[]{
                1,1,3,4,4
        });
        assertEquals(8,yatziGame.scoreAs(YatziCombination.PAIR));

        // FAIL
        yatziGame = new Yatzi(new int[]{
                6,2,1,4,5
        });
        assertEquals(0,yatziGame.scoreAs(YatziCombination.PAIR));
    }


    @Test
    void shouldScoreChanceTest(){
        var yatziGame = new Yatzi(new int[]{
                1,2,3,4,5
        });
        assertEquals(1+2+3+4+5,yatziGame.scoreAs(YatziCombination.CHANCE));

        yatziGame = new Yatzi(new int[]{
                1,2,5,4,6
        });
        assertEquals(1+2+5+4+6,yatziGame.scoreAs(YatziCombination.CHANCE));


    }

    @Test
    void shouldScoreTwoPairsTest(){
        var yatziGame = new Yatzi(new int[]{
                1,1,3,4,4
        });
        assertEquals(10,yatziGame.scoreAs(YatziCombination.TWOPAIRS));

         yatziGame = new Yatzi(new int[]{
                5,3,3,5,4
        });
        assertEquals(16,yatziGame.scoreAs(YatziCombination.TWOPAIRS));

        // FAIL
        yatziGame = new Yatzi(new int[]{
                6,2,1,4,5
        });
        assertEquals(0,yatziGame.scoreAs(YatziCombination.TWOPAIRS));
    }

    @Test
    void shouldScoreThreeOfaKind(){
        var yatziGame = new Yatzi(new int[]{
                5,5,3,5,4
        });
        assertEquals(15,yatziGame.scoreAs(YatziCombination.THREEOFAKIND));

        // FAIL
        yatziGame = new Yatzi(new int[]{
                6,2,1,4,5
        });
        assertEquals(0,yatziGame.scoreAs(YatziCombination.THREEOFAKIND));
    }

    @Test
    void shouldScoreFourOfaKind(){
        var yatziGame = new Yatzi(new int[]{
                5,5,5,5,4
        });
        assertEquals(20,yatziGame.scoreAs(YatziCombination.FOUROFAKIND));

        // FAIL
        yatziGame = new Yatzi(new int[]{
                6,2,1,4,5
        });
        assertEquals(0,yatziGame.scoreAs(YatziCombination.FOUROFAKIND));
    }

    @Test
    void shouldScoreSmallStraight(){
        var yatziGame = new Yatzi(new int[]{
                1,2,3,4,5
        });
        assertEquals(15,yatziGame.scoreAs(YatziCombination.SMALLSTRAIGHT));

        // FAIL
        yatziGame = new Yatzi(new int[]{
                6,2,1,4,5
        });
        assertEquals(0,yatziGame.scoreAs(YatziCombination.SMALLSTRAIGHT));


        yatziGame = new Yatzi(new int[]{
                1,2,2,5,5
        });
        assertEquals(0,yatziGame.scoreAs(YatziCombination.SMALLSTRAIGHT));

    }

    @Test
    void shouldScoreBigStraight(){
        var yatziGame = new Yatzi(new int[]{
                2,3,4,5,6
        });
        assertEquals(20,yatziGame.scoreAs(YatziCombination.BIGSTRAIGHT));

        // FAIL
        yatziGame = new Yatzi(new int[]{
                6,2,1,4,5
        });
        assertEquals(0,yatziGame.scoreAs(YatziCombination.SMALLSTRAIGHT));
    }

}

