package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;




public class LoginFrame extends JFrame implements ItemListener, ActionListener {
    private JTextField textField;
    private JPasswordField passwordField;

    public static void main(String args[]) {
        new LoginFrame().setVisible(true);
        // 设置窗体可见，默认为不可见

    }

    final JRadioButton people = new JRadioButton("游客");
    final JRadioButton manager = new JRadioButton("管理员");
    final JRadioButton normaluser = new JRadioButton("普通用户");
    final JButton addButton = new JButton();
    final JButton exitButton = new JButton();
    final JButton landButton = new JButton();
    int tmp=0;//默认游客

    public LoginFrame() {
        super(); // 继承父类的构造方法
        setTitle("登录");
        setBounds(100, 100, 300, 300); // 设置窗体的显示位置及大小 height = 窗体的高
        getContentPane().setLayout(null); // 设置为不采用任何布局管理器
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel label = new JLabel();
        label.setBorder(new TitledBorder(null, "",
                TitledBorder.DEFAULT_JUSTIFICATION,
                TitledBorder.DEFAULT_POSITION, null, null));
        label.setForeground(new Color(255, 0, 0));
        label.setFont(new Font("", Font.BOLD, 18));

        JLabel helloLabel = new JLabel("New label");
        helloLabel.setIcon(new ImageIcon("src/img/1.gif"));
        helloLabel.setBackground(Color.BLACK);
        helloLabel.setBounds(60, 20, 170, 80);
        getContentPane().add(helloLabel); //图片显示

        final JLabel usernameLabel = new JLabel();
        usernameLabel.setText("用户名");
        usernameLabel.setBounds(43, 110, 60, 15); // 设置“用户名”标签的显示位置及大小
        getContentPane().add(usernameLabel);

        textField = new JTextField();
        textField.setBounds(94, 107, 120, 21); // 设置“用户名”文本框的显示位置及大小
        getContentPane().add(textField);

        final JLabel passwordLabel = new JLabel();
        passwordLabel.setText("密  码");
        passwordLabel.setBounds(43, 137, 60, 15); // 设置“密 码”标签的显示位置及大小
        getContentPane().add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(94, 134, 120, 21); // 设置“密 码”密码框的显示位置及大小
        getContentPane().add(passwordField);

//        JButton addButton = new JButton();
        addButton.setText("注册");
        addButton.setBounds(30, 210, 60, 23); // 设置“退出”按钮的显示位置及大小
        getContentPane().add(addButton);


//        JButton exitButton = new JButton();
        exitButton.setText("退出");
        exitButton.setBounds(200, 210, 60, 23); // 设置“退出”按钮的显示位置及大小
        getContentPane().add(exitButton);

//        JButton landButton = new JButton();
        landButton.setText("登录");
        landButton.setBounds(115, 210, 60, 23); // 设置“登录”按钮的显示位置及大小
        getContentPane().add(landButton);

        ButtonGroup buttongroup = new ButtonGroup();
//        JRadioButton manager=new JRadioButton("管理员");
        manager.setBounds(30, 170, 70, 20);
        buttongroup.add(manager);
        getContentPane().add(manager);


//        JRadioButton normaluser=new JRadioButton("普通用户");
        normaluser.setBounds(110, 170, 75, 20);
        buttongroup.add(normaluser);
        getContentPane().add(normaluser);

        people.setBounds(200, 170, 75, 20);
        buttongroup.add(people);
        getContentPane().add(people);

        manager.addItemListener(this);
        normaluser.addItemListener(this);
        landButton.addActionListener(this);
        exitButton.addActionListener(this);
        addButton.addActionListener(this);
        people.setSelected(true);
        people.addItemListener(this);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getSource() == manager) {
            tmp = 1;
        } else if (e.getSource() == normaluser) {
            tmp = 0;
        }
        else if (e.getSource() == people) {
            tmp = 3;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == landButton) {


            if (tmp == 1)//判断里加一个判断条件：数据库中是权限对应数值是否与tmp相等
            {
            new Manger_data();//管理员窗口
            setVisible(false);
                System.out.println("管理员窗口");
            }
            else if (tmp == 2)
            {
            new normaluser_data();//普通用户窗口
            setVisible(false);
                System.out.println("普通用户窗口");
            }
            else if (tmp == 0)
            {

            new people_data();//游客用户窗口
            setVisible(false);
                System.out.println("游客用户窗口");
            }
        }

            else if (e.getSource() == exitButton)
            {
//            dispose();
                System.exit(0);

            }

            else if (e.getSource() == addButton)
            {
                this.dispose();
                RegisterFrame frame_1 = new RegisterFrame();
            }


}
}

