import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    JFrame f = new JFrame();
    JPanel t_panel = new JPanel();
    JPanel bt_panel = new JPanel();
    JLabel turn = new JLabel();
    JButton[] Btn = new JButton[9];
    int chance_flag = 0;
    Random random = new Random();
    boolean player1_chance;
    
    TicTacToe() {

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(700, 700);
        f.getContentPane().setBackground(new Color(255, 255, 255));
        f.setTitle("Tic Tac Toe");
        f.setLayout(new BorderLayout());
        f.setVisible(true);

        bt_panel.setLayout(new GridLayout(3, 3));
        bt_panel.setBackground(new Color(15, 150, 150));

        for (int i = 0; i < 9; i++) {
            Btn[i] = new JButton();
            bt_panel.add(Btn[i]);
            Btn[i].setFont(new Font("Noto sans", Font.BOLD, 120));
            Btn[i].setFocusable(false);
            Btn[i].addActionListener(this);
        }
        
        t_panel.add(turn);
        f.add(t_panel, BorderLayout.NORTH);
        f.add(bt_panel);

        StartGame();
    }

    public void StartGame() {
        int chance=random.nextInt(100);

        if (chance%2 == 0) {
            player1_chance = true;
            turn.setText("X turn");
        } else {
            player1_chance = false;
            turn.setText("O turn");
        }
    }
    public void GameOver(String s){
        chance_flag = 0;
        Object[] option={"Restart","Exit"};
        int n=JOptionPane.showOptionDialog(f, "Game Over\n"+s,"Game Over",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,option,option[0]);
        if(n==0){
            f.dispose();
            new TicTacToe();
        }
        else{
            f.dispose();
        }
    
    }

    public void matchPossibilities() {
        if ((Btn[0].getText() == "X") && (Btn[1].getText() == "X") && (Btn[2].getText() == "X")) {
            xWins(0, 1, 2);
        }
        else if ((Btn[0].getText() == "X") && (Btn[4].getText() == "X") && (Btn[8].getText() == "X")) {
            xWins(0, 4, 8);
        }
        else if ((Btn[0].getText() == "X") && (Btn[3].getText() == "X") && (Btn[6].getText() == "X")) {
            xWins(0, 3, 6);
        }
        else if ((Btn[1].getText() == "X") && (Btn[4].getText() == "X") && (Btn[7].getText() == "X")) {
            xWins(1, 4, 7);
        }
        else if ((Btn[2].getText() == "X") && (Btn[4].getText() == "X") && (Btn[6].getText() == "X")) {
            xWins(2, 4, 6);
        }
        else if ((Btn[2].getText() == "X") && (Btn[5].getText() == "X") && (Btn[8].getText() == "X")) {
            xWins(2, 5, 8);
        }
       else if ((Btn[3].getText() == "X") && (Btn[4].getText() == "X") && (Btn[5].getText() == "X")) {
            xWins(3, 4, 5);
        }
       else if ((Btn[6].getText() == "X") && (Btn[7].getText() == "X") && (Btn[8].getText() == "X")) {
            xWins(6, 7, 8);
        }
      
        else if ((Btn[0].getText() == "O") && (Btn[1].getText() == "O") && (Btn[2].getText() == "O")) {
            oWins(0, 1, 2);
        }
        else if ((Btn[0].getText() == "O") && (Btn[3].getText() == "O") && (Btn[6].getText() == "O")) {
            oWins(0, 3, 6);
        }
        else if ((Btn[0].getText() == "O") && (Btn[4].getText() == "O") && (Btn[8].getText() == "O")) {
            oWins(0, 4, 8);
        }
        else if ((Btn[1].getText() == "O") && (Btn[4].getText() == "O") && (Btn[7].getText() == "O")) {
            oWins(1, 4, 7);
        }
        else if ((Btn[2].getText() == "O") && (Btn[4].getText() == "O") && (Btn[6].getText() == "O")) {
            oWins(2, 4, 6);
        }
        else if ((Btn[2].getText() == "O") && (Btn[5].getText() == "O") && (Btn[8].getText() == "O")) {
            oWins(2, 5, 8);
        }
        else if ((Btn[3].getText() == "O") && (Btn[4].getText() == "O") && (Btn[5].getText() == "O")) {
            oWins(3, 4, 5);
        } else if ((Btn[6].getText() == "O") && (Btn[7].getText() == "O") && (Btn[8].getText() == "O")) {
            oWins(6, 7, 8);
        }
        else if(chance_flag==9) {
            turn.setText("Match Tie");
             GameOver("Match Tie");
        }
    }

    public void xWins(int x1, int x2, int x3) {
        Btn[x1].setBackground(Color.GREEN);
        Btn[x2].setBackground(Color.GREEN);
        Btn[x3].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            Btn[i].setEnabled(false);
        }
        turn.setText("X wins");
        GameOver("X Wins");
    }

    public void oWins(int x1, int x2, int x3) {
        Btn[x1].setBackground(Color.GREEN);
        Btn[x2].setBackground(Color.GREEN);
        Btn[x3].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            Btn[i].setEnabled(false);
        }
        turn.setText("O Wins");
        GameOver("O Wins");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 9; i++) {
            if (e.getSource() == Btn[i]) {
                if (player1_chance) {
                    if (Btn[i].getText() == "") {
                        Btn[i].setForeground(new Color(255, 0, 0));
                        Btn[i].setText("X");
                        player1_chance = false;
                        turn.setText("O turn");
                        chance_flag++;
                        matchPossibilities();
                    }
                } else {
                    if (Btn[i].getText() == "") {
                        Btn[i].setForeground(new Color(0, 0, 255));
                        Btn[i].setText("O");
                        player1_chance = true;
                        turn.setText("X turn");
                        chance_flag++;
                        matchPossibilities();
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        new TicTacToe();
    }

}