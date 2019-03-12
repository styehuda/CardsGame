/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

public class Deck{
    
    private ArrayList<Card> heap = new ArrayList<Card>();
    
    public Deck(){
        int value;
        String type;
        String path;
        String [] types = {"hearts", "clubs", "diamonds", "spades"};
        for (int i = 1; i < 53; i++){
            if (i % 13 == 1)
                value = 14;
            else if (i % 13 == 0)
                value = 13;
            else value = (i % 13);
            type = types[(i-1)/13];
            path = "C:\\Users\\User\\Desktop\\img\\" + i + ".png";
            heap.add(new Card(value,type,path));
        }    
    }
    
    public ArrayList<Card> getHeap(){
        return heap;
    }
    
}
