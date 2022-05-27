package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class person_doc implements ActionListener {
    String yonghuming="nidie";
    String dianziyouxiang;
    String mima;
    String quanxian;
    JButton buttonregister_1 = new JButton("修改");
    JButton buttonregister_3 = new JButton("返回");
    JFrame frame = new JFrame("个人信息");
    person_doc(){

        frame.setLayout(null);
        JLabel nameStr = new JLabel("用户名");
        nameStr.setBounds(60, 50, 60, 15);
        frame.add(nameStr);

        JLabel mail = new JLabel("电子邮箱");
        mail.setBounds(45, 80, 60, 15);
        frame.add(mail);

        JLabel passwordStr = new JLabel("密 码");
        passwordStr.setBounds(60, 110, 60, 15);
        frame.add(passwordStr);

        JLabel powerStr = new JLabel("权 限");
        powerStr.setBounds(60, 140, 60, 15);
        frame.add(powerStr);

        JLabel userName = new JLabel(yonghuming);
        userName.setBounds(100, 48, 120, 21);
        frame.add(userName);
        userName.setBorder(null);//去边框
        userName.setOpaque(false);//透明化

        JLabel useremail = new JLabel(yonghuming);
        useremail.setBounds(100, 77, 120, 21);
        frame.add(useremail);
        useremail.setBorder(null);//去边框
        useremail.setOpaque(false);//透明化

        JPasswordField password = new JPasswordField(yonghuming);
        password.setEditable(false);
        password.setBounds(100, 108, 120, 21);
        frame.add(password);
        password.setBorder(null);//去边框
        password.setOpaque(false);//透明化

        JLabel powerstr = new JLabel(yonghuming);
        powerstr.setBounds(100, 138, 120, 21);
        frame.add(powerstr);
        powerstr.setBorder(null);//去边框
        powerstr.setOpaque(false);//透明化


        buttonregister_1.setBounds(30, 190, 60, 23);
        frame.add(buttonregister_1);


        buttonregister_3.setBounds(130, 190, 60, 23);
        frame.add(buttonregister_3);
        frame.setBounds(100, 100, 250, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        buttonregister_1.addActionListener(this);
        buttonregister_3.addActionListener(this);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonregister_1){
            frame.dispose();
            new Modification();
//            System.out.printf("你二臂啊");
        }
        else if (e.getSource()==buttonregister_3){
            frame.setVisible(false);
        }

    }
}
