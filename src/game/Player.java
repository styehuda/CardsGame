
package game;

import java.util.ArrayList;

public class Player {
    
    private ArrayList<Card> myCards = new ArrayList<Card>();
    private String name;
    private Card currentCard;
    
    public Player(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public ArrayList<Card> getMycards(){
        return myCards;
    }
    
    public Card getCurrentCard(){
        return currentCard;
    }
    
    public Card nextStep(){
        currentCard = myCards.remove(0);
        return currentCard;
    }
    
    public void winRound(ArrayList<Card> other){
        myCards.addAll(other);
    }
}
