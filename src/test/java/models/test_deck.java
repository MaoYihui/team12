package models;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class test_deck {
    @Test
    public void test_build_deck(){
        Deck d = new Deck();
        d.buildDeck();
        assertEquals(52, d.deck.size());
    }

    @Test
    public void test_spanish_build_deck(){
        Deck d = new Deck();
        d.spanish_buildDeck();
        assertEquals(50, d.deck.size());
    }

    @Test
    public void test_shuffle(){
        Deck d = new Deck();
        Deck dd = new Deck();
        d.buildDeck();
        d.shuffle();
        dd.buildDeck();
        dd.shuffle();
        assertNotEquals(d, dd);
    }

    @Test
    public void test_spanish_shuffle(){
        Deck d = new Deck();
        Deck dd = new Deck();
        d.spanish_buildDeck();
        d.spanish_shuffle();
        dd.spanish_buildDeck();
        dd.spanish_buildDeck();
        assertNotEquals(d, dd);
    }

    @Test
    public void test_deal_four(){
        Game g = new Game();
        g.deck.buildDeck();
        g.deck.dealFour(g.cols);

        assertEquals("2Clubs", g.cols.get(0).get(0).toString());
        assertEquals("2Hearts", g.cols.get(1).get(0).toString());
        assertEquals("2Diamonds", g.cols.get(2).get(0).toString());
        assertEquals("2Spades", g.cols.get(3).get(0).toString());

        assertEquals(48, g.deck.deck.size());

        // test spanish game last deal
        Game sg = new Game();
        sg.deck.spanish_buildDeck();

        for (int i = 0; i < 13; i++){
            sg.deck.dealFour(sg.cols);
        }

        assertNotEquals(null, sg.cols.get(0).get(12));
        assertEquals("12copas", sg.cols.get(3).get(11).toString());
    }
}
