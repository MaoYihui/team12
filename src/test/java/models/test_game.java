package models;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class test_game {

    @Test
    public void test_newgame(){
        Game a = new Game();
        assertNotNull(a);

    }

    @Test
    public void test_setdealfour(){
        Game a = new Game();
        a.deck.buildDeck();
        a.setdealfour();
        assertEquals(48, a.deck.deck.size());

    }

    @Test
    public void test_remove(){
        Game a = new Game();
        a.deck.buildDeck();
        a.setdealfour();
        a.remove(0);
        assertEquals(1,a.cols.get(0).size());
        Game A = new Game();
        Card C = new Card(0, Suit.comodines);
        Card D = new Card(1, Suit.bastos);
        A.cols.get(0).add(C);
        A.cols.get(1).add(D);
        A.remove(1);

        assertEquals(0,A.cols.get(0).size());
        assertEquals(0,A.cols.get(1).size());


        Game B = new Game();
        Card F= new Card(0, Suit.comodines);
        Card G= new Card(0, Suit.comodines);
        Card H= new Card(0, Suit.espadas);
        B.deck.buildDeck();
        B.cols.get(0).add(F);
        B.cols.get(1).add(G);
        B.cols.get(2).add(H);

        B.remove(2);
        assertEquals(1,B.cols.get(0).size()+B.cols.get(1).size());


    }

    @Test
    public void test_move(){
        Game a = new Game();
        Card c = new Card(14, Suit.Hearts);
        a.deck.buildDeck();

        a.cols.get(0).add(c);
        a.move(0,2);
        assertEquals(1,a.cols.get(2).size());
        assertEquals(0,a.cols.get(0).size());

        Game A = new Game();
        Card C= new Card(2, Suit.bastos);
        A.deck.buildDeck();

        A.cols.get(0).add(C);
        A.move(0,2);
        assertEquals(1,A.cols.get(2).size());
        assertEquals(0,A.cols.get(0).size());






    }
    //this.cols.get(columnFrom).get(this.cols.get(columnFrom).size() - 1).getSuit()
//cols.get(columnTo).add(cardToMove);
    @Test
    public void test_addCardToCol(){
     Game a= new Game();
        Card c = new Card(3, Suit.Hearts);
     a.cols.get(0).add(c);
        assertEquals(Suit.Hearts,a.cols.get(0).get(a.cols.get(0).size()-1).getSuit());
        assertEquals(3,a.cols.get(0).get(a.cols.get(0).size()-1).getValue());
    }

}
