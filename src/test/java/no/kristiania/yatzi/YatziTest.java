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
    }

    @Test
    void shouldScoreTwosTest(){
        var yatziGame = new Yatzi(new int[]{
                1,2,3,2,5
        });
        assertEquals(4,yatziGame.scoreAs(YatziCombination.TWOS));
    }

    @Test
    void shouldScoreThreesTest(){
        var yatziGame = new Yatzi(new int[]{
                3,3,3,2,5
        });
        assertEquals(9,yatziGame.scoreAs(YatziCombination.THREES));
    }


    @Test
    void shouldScorePairTest(){
        var yatziGame = new Yatzi(new int[]{
                1,2,2,4,5
        });
        assertEquals(4,yatziGame.scoreAs(YatziCombination.PAIR));
    }

    @Test
    void shouldScoreTheHighestPairTest(){
        var yatziGame = new Yatzi(new int[]{
                1,1,3,4,4
        });
        assertEquals(8,yatziGame.scoreAs(YatziCombination.PAIR));
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
    }

    @Test
    void shouldScoreThreeOfaKind(){
        var yatziGame = new Yatzi(new int[]{
                5,5,3,5,4
        });
        assertEquals(15,yatziGame.scoreAs(YatziCombination.THREEOFAKIND));
    }

}

