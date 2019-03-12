
package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ThreadGame extends JFrame implements ActionListener{
    private Play play;
    private JButton button = new JButton("start game");
    private JLabel right = new JLabel("");
    private JLabel left = new JLabel("");
    private JLabel first = new JLabel("");
    private JLabel second = new JLabel("");
    private JLabel nothing = new JLabel("");
    public ThreadGame(){
        super();
        String name1 = JOptionPane.showInputDialog("First player, Enter your name");
        String name2 = JOptionPane.showInputDialog("Second player, Enter your name");
        play = new Play(new Player(name1),new Player(name2));
        add(play,BorderLayout.CENTER);
        first.setText(name1);
        second.setText(name2);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,3));
        panel.add(first);
        panel.add(nothing);
        panel.add(second);
        panel.add(right);
        panel.add(button);
        panel.add(left);
        button.addActionListener(this);
        add(panel,BorderLayout.SOUTH);
        setSize(300,500);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(button.getText()=="war"){
            play.war(play.roundCards);
        }
        if(button.getText()=="start game" || button.getText()=="next round"){
            play.round();
        }
        if(button.getText()=="finish"){
            String str = play.win + " winner";
            JOptionPane.showMessageDialog(null,str);
        }
        if (play.winner==0){
            button.setText("war");
            right.setText("");
            left.setText("");
        }
        if (play.winner==1){
            button.setText("next round");
            right.setText("winner");
            left.setText("");
        }
        if (play.winner==2){
            button.setText("next round");
            left.setText("winner");
            right.setText("");
        }
        if (play.finish){
            button.setText("finish");
        }
        first.setText(play.p1.getName()+": "+play.p1.getMycards().size());
        second.setText(play.p2.getName()+": "+play.p2.getMycards().size());
    }
    public static void main(String[]args){
        ThreadGame game = new ThreadGame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
