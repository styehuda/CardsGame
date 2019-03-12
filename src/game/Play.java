
package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class Play extends JPanel{
    
    public Player p1;
    public Player p2;
    public int roundNum = 0;
    public String msg = "";
    public boolean finish = false;
    public int winner = 1;
    public String win ="";
    private Image img1;
    private Image img2;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    public ArrayList<Card> roundCards = new ArrayList<Card>();
    public Play (Player p1, Player p2){
        this.p1 = p1;
        this.p2 = p2;
        Deck deck = new Deck();
        int temp, temp2=0 ;
        while (!deck.getHeap().isEmpty()){
            Random rand = new Random();
            temp = rand.nextInt(deck.getHeap().size());
            if (temp2%2 == 0)
                p1.getMycards().add(deck.getHeap().remove(temp));
            else p2.getMycards().add(deck.getHeap().remove(temp));
            temp2++;
        }
    }
    
    public void round(){
        if(winner!=0)
            roundNum++;
        roundCards.removeAll(roundCards);
        roundCards.add(p1.nextStep());
        roundCards.add(p2.nextStep());
        img1 = toolkit.getImage(p1.getCurrentCard().path);
        img2 = toolkit.getImage(p2.getCurrentCard().path);
        repaint();
        if(p1.getCurrentCard().getValue() == p2.getCurrentCard().getValue()){
            winner = 0;
        }
        else if(p1.getCurrentCard().getValue() > p2.getCurrentCard().getValue()){
            p1.winRound(roundCards);
            winner = 1;
            if (p2.getMycards().isEmpty()){
                finish=true;
                win += p1.getName();
            }
        }
        else {
            p2.winRound(roundCards);
            winner = 2;
            if (p1.getMycards().isEmpty()){
                finish=true;
                win += p2.getName();
            }
        }
    }
    
    public void war(ArrayList<Card> roundCards){
        for (int i=0; i<4; i++){
            if (!p1.getMycards().isEmpty())
                roundCards.add(p1.nextStep());       
            if (!p1.getMycards().isEmpty())
                roundCards.add(p1.nextStep());
        }
        if(p1.getCurrentCard().getValue() > p2.getCurrentCard().getValue()){
            p1.winRound(roundCards);
            winner = 1;
            if (p2.getMycards().isEmpty()){
                finish=true;
                win += p1.getName();
            }
        }
        else if(p2.getCurrentCard().getValue() > p1.getCurrentCard().getValue()){
            p2.winRound(roundCards);
            winner = 2;
            if (p1.getMycards().isEmpty()){
                finish=true;
                win += p2.getName();
            }
        }
        img1 = toolkit.getImage(p1.getCurrentCard().path);
        img2 = toolkit.getImage(p2.getCurrentCard().path);
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img1, 20, 20, this);
        g.drawImage(img2, 520, 20, this);
    }
}
