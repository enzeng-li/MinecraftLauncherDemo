package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.util.Date;


public class Manger_data implements ActionListener {
//管理员
    final JButton buttonregister_2 = new JButton("退出");
    JButton buttonregister_1 = new JButton("游戏启动");
    JButton psdoc = new JButton("个人资料");
    JButton ksweb = new JButton("管理员功能");
    JButton newmesag = new JButton("新消息");
    JButton newmesag_1 = new JButton("发布消息");
    Manger_data() {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        JLabel userStr = new JLabel("用户名:");
        userStr.setBounds(60, 30, 100, 50);
        frame.add(userStr);
        userStr.setFont(new Font("宋体", Font.PLAIN,16));
        JLabel userstr= new JLabel();
        userstr.setBounds(120, 30, 100, 50);
        userstr.setFont(new Font("宋体", Font.PLAIN,16));

        psdoc.setBounds(60, 80, 100, 30);
        frame.add(psdoc);
        psdoc.setBorderPainted(false);//去边框

        ksweb.setBounds(60, 120, 100, 30);
        frame.add(ksweb);

        ksweb.setBorderPainted(false);

        newmesag.setBounds(60, 160, 100, 30);
        frame.add(newmesag);
        newmesag.setBorderPainted(false);

        newmesag_1.setBounds(60, 200, 100, 30);
        frame.add(newmesag_1);
        newmesag_1.setBorderPainted(false);//去边框




        buttonregister_1.setBounds(300, 60, 100, 60);
        buttonregister_1.setFont(new Font(null, 0,16));
        frame.add(buttonregister_1);
        buttonregister_1.setBorderPainted(false);//去边框


        buttonregister_2.setBounds(300, 150, 100, 60);
        buttonregister_2.setFont(new Font(null, 0,16));
        frame.add(buttonregister_2);
        buttonregister_2.setBorderPainted(false);//去边框


        frame.setBounds(160, 200, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        buttonregister_1.addActionListener(this);
        buttonregister_2.addActionListener(this);
        psdoc.addActionListener(this);
        ksweb.addActionListener(this);
        newmesag.addActionListener(this);
        newmesag_1.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == buttonregister_2)
        {
//            dispose();
            System.exit(0);

        }


        else if (e.getSource()==buttonregister_1)
        {
             new Game_address();
         }

        else if(e.getSource()==psdoc)
        {
            new person_doc();
         }
        else if(e.getSource()==ksweb)
         {
             new administrator_features();
         }
        else if(e.getSource()==newmesag)
         {
             new newmassage();
         }
        else if(e.getSource()==newmesag_1)
         {
             try {
                 new sendmassage();
             } catch (UnknownHostException ex) {
                 throw new RuntimeException(ex);
             }
         }
    }








}
