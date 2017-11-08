package models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Deck {

    public java.util.List<Card> deck = new ArrayList<>();

    public void buildDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void shuffle() {
        // shuffles the deck so that it is random
        Card temp_card;

        int min = 0;
        int max = 51;

        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int s = random.nextInt(max) % (max - min + 1) + min;

            temp_card = deck.get(s);
            deck.set(s, deck.get(0));
            deck.set(0, temp_card);
        }
    }
    public void dealFour(java.util.List<java.util.List<Card>> cols) {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
        cols.get(0).add(deck.get(0));
        cols.get(1).add(deck.get(1));
        cols.get(2).add(deck.get(2));
        cols.get(3).add(deck.get(3));
        deck.remove(0);
        deck.remove(0);
        deck.remove(0);
        deck.remove(0);

    }
}
