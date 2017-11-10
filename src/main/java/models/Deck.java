package models;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
/*
interface deck_issues{
    void buildDeck();
    Card get_card(int num);
    void set_card(int s, Card card);
    void remove_card(int num);

}
*/

public class Deck /*implements deck_issues */{

    public java.util.List<Card> deck=new ArrayList<>();

//     Deck(){

  //      deck = new ArrayList<>();

    //}

    //public java.util.List<Card> deck = new ArrayList<>();

    //public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);

    public void add_card(Card A){

        deck.add(A);
    }


    public void buildDeck( ) {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public Card get_card(int num){

        return deck.get(num);
    }

    public void  set_card(int s, Card card){

        deck.set(s, card);
    }
    public void remove_card(int num) {


         deck.remove(num);
    }

    public java.util.List<Card> get_deck(){
        return deck;

    }




}