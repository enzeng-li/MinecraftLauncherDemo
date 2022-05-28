package view;

import db.RegisterDB;
import db.updata;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class AddFrame implements KeyListener {
    JTextField adduser_1 = new JTextField();
    private static String s;
    JFrame frame = new JFrame("添加用户");
    AddFrame(){
        frame.setLayout(null);
        frame.setBounds(160, 200, 450, 100);

        JLabel addrestr= new JLabel("新用户为");
        addrestr.setBounds(30, 4, 50, 50);
        frame.add(addrestr);
        frame.setLocationRelativeTo(null);


        adduser_1.setBounds(90, 20, 300, 21);
        frame.add(adduser_1);


        frame.setVisible(true);
        adduser_1.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER){
            s=adduser_1.getText();
            System.out.printf(s);
            RegisterDB Re = new RegisterDB();
            try {
                Re.insert_user_tourist(s);//初始密码000000
                frame.dispose();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            frame.setVisible(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
