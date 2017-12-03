package models;

import org.junit.Test;
import static org.junit.Assert.*;

public class test_card {
    @Test
    public void test_card_creator(){
        Card c = new Card(5, Suit.Hearts);
        assertEquals(5, c.value);
        assertNotEquals(4, c.value);
        assertEquals(Suit.Hearts, c.suit);
        assertNotEquals(Suit.Clubs, c.suit);
    }

    @Test
    public void test_get_suit(){
        Card c = new Card(5, Suit.Hearts);
        assertEquals(Suit.Hearts, c.getSuit());
        assertNotEquals(Suit.Clubs, c.getSuit());
    }

    @Test
    public void test_get_value(){
        Card c = new Card(5, Suit.Hearts);
        assertEquals(5, c.getValue());
        assertNotEquals(4, c.getValue());
    }

    @Test
    public void test_to_string(){
        Card c = new Card(5, Suit.Hearts);
        assertEquals("5Hearts", c.toString());
        assertNotEquals("4Hearts", c.toString());
    }
}
