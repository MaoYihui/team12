package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Assignment 1: Each of the blank methods below require implementation to get AcesUp to build/run
 */
public class Game {



    public java.util.List<java.util.List<Card>> cols = new ArrayList<>(4);
    public Deck deck= new Deck();



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
    
    }

    public void setdealfour(){
        deck.dealFour(cols);
    }







    public void remove(int columnNumber) {
        // remove the top card from the indicated column
        int count=0;
        int num=0;
        int joker=0;
        int index=0;
        for(int i=0; i<4; i++){
            if(cols.get(i).size()!=0) {
                if(cols.get(i).get(cols.get(i).size() - 1).getSuit()==Suit.comodines) {
                    joker++;
                    index=i;
                }
                if (cols.get(columnNumber).get(cols.get(columnNumber).size() - 1).getSuit() == cols.get(i).get(cols.get(i).size() - 1).getSuit()){
                    count++;
                if (cols.get(columnNumber).get(cols.get(columnNumber).size() - 1).getValue() < cols.get(i).get(cols.get(i).size() - 1).getValue())
                    num++;}
            }
        }
        if(joker==1) {
        if(cols.get(columnNumber).get(cols.get(columnNumber).size() - 1).getSuit()!=Suit.comodines) {
            cols.get(columnNumber).remove(cols.get(columnNumber).get(this.cols.get(columnNumber).size() - 1));
            cols.get(index).remove(cols.get(index).get(this.cols.get(index).size() - 1));
        }
        }
        else if(joker==2){
            if(cols.get(columnNumber).get(cols.get(columnNumber).size() - 1).getSuit()!=Suit.comodines){
                cols.get(columnNumber).remove(cols.get(columnNumber).get(this.cols.get(columnNumber).size() - 1));
                cols.get(index).remove(cols.get(index).get(this.cols.get(index).size() - 1));
            }
            else{

                cols.get(columnNumber).remove(cols.get(columnNumber).get(this.cols.get(columnNumber).size() - 1));
            }

        }
        else if (count >1){
            if (num>0)
            cols.get(columnNumber).remove(cols.get(columnNumber).get(this.cols.get(columnNumber).size() - 1));
        }
    }

    private boolean columnHasCards(int columnNumber) {
        // check indicated column for number of cards; if no cards return false, otherwise return true
     if(cols.contains(columnNumber))

            return true;
        else
            return false;


    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int columnFrom, int columnTo) {
        // remove the top card from the columnFrom column, add it to the columnTo column
        int a;
        int b=0;

        a=cols.get(columnTo).size();


            if(this.cols.get(columnFrom).get(this.cols.get(columnFrom).size() - 1).getSuit()==Suit.Clubs)
                b=1;
            else if (this.cols.get(columnFrom).get(this.cols.get(columnFrom).size() - 1).getSuit()==Suit.Diamonds)
                b=1;
            else if (this.cols.get(columnFrom).get(this.cols.get(columnFrom).size() - 1).getSuit()==Suit.Spades)
                b=1;
            else if (this.cols.get(columnFrom).get(this.cols.get(columnFrom).size() - 1).getSuit()==Suit.Hearts)
                b=1;


        //System.out.println("\\\\\\\\\\\\\\\\a="+a);
        if (a==0) {
             if((this.cols.get(columnFrom).get(this.cols.get(columnFrom).size() - 1).getValue()==14)&&(b==1)) {
                 addCardToCol(columnTo, this.cols.get(columnFrom).get(this.cols.get(columnFrom).size() - 1));
                 removeCardFromCol(columnFrom);
                 //addCardToCol(columnTo,this.cols.get(columnFrom).get(this.cols.get(columnFrom).size()-1));
             }
             else if((this.cols.get(columnFrom).get(this.cols.get(columnFrom).size() - 1).getValue()!=14)&&(b==1)){
                 System.out.println("good");
             }
             else{
                 addCardToCol(columnTo, this.cols.get(columnFrom).get(this.cols.get(columnFrom).size() - 1));
                 removeCardFromCol(columnFrom);
             }
             }
    }

    private void addCardToCol(int columnTo, Card cardToMove) {
        cols.get(columnTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);
    }
}
