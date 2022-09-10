package no.kristiania.yatzi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatziTest {

    @Test
    void shouldScoreChanceTest(){
        var yatziGame = new Yatzi(new int[]{
                1,2,3,4,5
        });
        assertEquals(1+2+3+4+5,yatziGame.scoreAs(YatziCombination.CHANCE));
    }

    @Test
    void shouldScoreOnesTest(){
        var yatziGame = new Yatzi(new int[]{
                1,2,1,4,5
        });
        assertEquals(1+1,yatziGame.scoreAs(YatziCombination.ONES));
    }
}
