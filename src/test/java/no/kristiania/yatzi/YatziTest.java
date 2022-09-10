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
    void shouldScoreChanceTest(){
        var yatziGame = new Yatzi(new int[]{
                1,2,3,4,5
        });
        assertEquals(1+2+3+4+5,yatziGame.scoreAs(YatziCombination.CHANCE));
    }
}
