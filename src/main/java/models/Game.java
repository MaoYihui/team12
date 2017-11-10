package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {

  // public java.util.List<Card> deck = new ArrayList<>();
   public Deck deck;

   public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);


    public Game(){
        // initialize a new game such that each column can store cards
        java.util.List<Card> cards_one = new ArrayList<>();
        java.util.List<Card> cards_two = new ArrayList<>();
        java.util.List<Card> cards_three = new ArrayList<>();
        java.util.List<Card> cards_four = new ArrayList<>();


        cols.add(cards_one);

        cols.add(cards_two);

        cols.add(cards_three);

        cols.add(cards_four);
        System.out.println("//////////////////////");
        deck=new Deck();

    }



    public void buildDeck() {

       deck.buildDeck();

    }
//



    public void shuffle() {
        // shuffles the deck so that it is random
        Card temp_card;

        int min = 0;
        int max = 51;
        
        for (int i = 0; i < 50; i++)
        {
            Random random = new Random();
            int s = random.nextInt(max)%(max-min+1) + min;


              temp_card=deck.get_card(s);

               deck.set_card(s,deck.get_card(0));

            deck.set_card(0,temp_card);

        }
    }

    public void dealFour() {
        // remove the top card from the deck and add it to a column; repeat for each of the four columns
       cols.get(0).add(deck.get_card(0));

        cols.get(1).add(deck.get_card(1));
        cols.get(2).add(deck.get_card(2));
        cols.get(3).add(deck.get_card(3));


        System.out.println("//////////////////////");

        deck.remove_card(0);
        deck.remove_card(0);
        deck.remove_card(0);
        deck.remove_card(0);
    
    }

    public void remove(int columnNumber) {
        // remove the top card from the indicated column
        int count=0;
        int num=0;
        for(int i=0; i<4; i++){
            if(cols.get(i).size()!=0) {
               if (cols.get(columnNumber).get(cols.get(columnNumber).size() - 1).getSuit() == cols.get(i).get(cols.get(i).size() - 1).getSuit()){

                    count++;
                if (cols.get(columnNumber).get(cols.get(columnNumber).size() - 1).getValue() < cols.get(i).get(cols.get(i).size() - 1).getValue())

                    num++;}
            }
        }
        if (count >1){
            if (num>0)
            cols.get(columnNumber).remove(cols.get(columnNumber).get(this.cols.get(columnNumber).size() - 1));
        }
    }

/*
    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
     if(cols.contains(columnNumber))

            return true;
        else
            return false;


    }
*/

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);

    }



    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        int a;

        a=cols.get(columnTo).size();

        if (a==0) {

           addCardToCol(columnTo, this.cols.get(columnFrom).get(this.cols.get(columnFrom).size() - 1));

            removeCardFromCol(columnFrom);

        }
    }

      private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
