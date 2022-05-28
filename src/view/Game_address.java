package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;



public class  Game_address implements KeyListener {
    JTextField addrestr_1 = new JTextField();
    private static String s;
    JFrame frame = new JFrame("游戏路径");
    Game_address(){

        frame.setLayout(null);
        frame.setBounds(160, 200, 450, 100);

        JLabel addrestr= new JLabel("路径为");
        addrestr.setBounds(30, 4, 50, 50);
        frame.add(addrestr);
        frame.setLocationRelativeTo(null);


        addrestr_1.setBounds(90, 20, 300, 21);
        frame.add(addrestr_1);


        frame.setVisible(true);
        addrestr_1.addKeyListener(this);
    }




//    public static void main(String[] args) {
//        new Game_address();
//    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER){
            s=addrestr_1.getText();
            System.out.printf(s);

            try {
                Desktop.getDesktop().open(new File(s));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            frame.setVisible(false);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
