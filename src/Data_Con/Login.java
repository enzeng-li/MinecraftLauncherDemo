package Data_Con;

import javax.xml.crypto.Data;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Login {
    private static String jdbcName ="com.mysql.cj.jdbc.Driver";
    private static String url ="jdbc:mysql://localhost:3306/player_management";
    //user名为指定的数据库
    private static String user="root";
    private static String password="lienzeng";
    private java.sql.Connection con;
    private PreparedStatement sta;


    public Login(){
        //加载数据库驱动:
        try {
            Class.forName(jdbcName);
            System.out.println("加载驱动成功");
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败");
        }

        //连接数据库
        try {
            con= DriverManager.getConnection(url,user,password);
            System.out.println("连接成功");
        } catch (SQLException e) {
            System.out.println("连接失败");
        }
    }

    //用户名、密码登录

    public int  Login_user(String name,String password) throws SQLException {
        String sql_select="select * from user where userName =?";
        sta= con.prepareStatement(sql_select);
        sta.setString(1,name);
        ResultSet show= sta.executeQuery();
        while(show.next()) {

            String name1 = show.getString(1);
            String password1 = show.getString(4);
            //字符串直接判断==时，出错
            if (password.equals(password1) ) {

                //更新最新登录时间和登录次数
                String sql_date="update user set latestLoginTime=now(),loginTimes=loginTimes+1 where userName=?";
                sta = con.prepareStatement(sql_date);
                sta.setString(1,name);
                sta.executeUpdate();
                //验证身份
                String sql_identity="select identity from user where userName=?";
                sta=con.prepareStatement(sql_identity);
                sta.setString(1,name);
                ResultSet show1=sta.executeQuery();
                show1.next();
                int  indentity=show1.getInt(1);
                System.out.println(indentity);
                show.close();
                sta.close();
                con.close();
                System.out.println("登录成功");
                return indentity;//匹配成功
                //返回1为普通用户
                //返回2为管理员
            }
            else {
                show.close();
                sta.close();
                con.close();
                System.out.println("密码错误");
                return -1;      //密码错误
            }
        }
        System.out.println("用户不存在");
        show.close();
        sta.close();
        con.close();
        return 0;               //用户不存在
    }

    //ID、密码登录
    public int  Login_ID(String ID,String password) throws SQLException {
        String sql_select="select * from user where ID =?";
        sta= con.prepareStatement(sql_select);
        sta.setString(1,ID);
        ResultSet show= sta.executeQuery();
        while(show.next()) {

            String ID1 = show.getString(1);
            String password1 = show.getString(4);

            if (password.equals(password1) ) {
                //更新最新登录时间和登录次数
                String sql_date="update user set latestLoginTime=now(),loginTimes=loginTimes+1 where id=?";
                sta = con.prepareStatement(sql_date);
                sta.setString(1,ID);
                sta.executeUpdate();
                //验证身份
                String sql_identity="select identity from user where ID=?";
                sta=con.prepareStatement(sql_identity);
                sta.setString(1,ID);
                ResultSet show1=sta.executeQuery();
                show1.next();
                int  indentity=show1.getInt(1);
                System.out.println(indentity);
                show.close();
                sta.close();
                con.close();
                System.out.println("登录成功");
                return indentity;       //匹配成功
                //返回1为普通用户
                //返回2为管理员
            }
            else {
                show.close();
                sta.close();
                con.close();
                System.out.println("密码错误");
                return -1;      //密码错误
            }
        }
        show.close();
        sta.close();
        con.close();
        System.out.println("用户不存在");
        return 0;               //用户不存在
    }
}
