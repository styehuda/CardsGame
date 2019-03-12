/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

public class Card {
    
    private int value;
    private String type;
    public String path;
    
    public Card(int v, String type, String path){
        value = v;
        this.type = type;
        this.path = path;
    }
    
    public int getValue(){
        return value;
    }
    
    public String getType(){
        return type;
    }
    
    public String getPath(){
        return path;
    }
}
