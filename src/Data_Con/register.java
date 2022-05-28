package Data_Con;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//注册用户：支持创建管理员用户，普通用户，默认用户
class register {
    private static String jdbcName ="com.mysql.cj.jdbc.Driver";
    private static String url ="jdbc:mysql://localhost:3306/player_management";
    //user名为指定的数据库
    private static String user="root";
    private static String password="lienzeng";
    private java.sql.Connection con;
    private PreparedStatement sta;
    public register(){
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

    //创建游客
    //返回用户名，密码默认000000
    public String insert_user_tourist() throws SQLException {
        String sql_count="select count(*) from user ";
        sta=con.prepareStatement(sql_count);
        ResultSet show1=sta.executeQuery();
        show1.next();
        int  sum=show1.getInt(1)+1;
        String username=new String("游客"+sum);
        try {

            String sql_insert="insert into user (userName,userPasswd,identity)values(?,\"000000\",0)";
            sta = con.prepareStatement(sql_insert);
            sta.setString(1,username);
            sta.executeUpdate();
            System.out.println("游客账号注册成功");

        } catch (SQLException e) {
            System.out.println("游客账户注册失败");
            throw new RuntimeException(e);
        }
        sta.close();
        con.close();
        return username;
    }

    //创建普通用户
    public void insert_user_general(String name,String pass,int ID) throws SQLException {
        try {
            String sql_insert="insert into user(userName,userPasswd,id,identity) values(?,?,?,1)";
            sta= con.prepareStatement(sql_insert);
            sta.setString(1,name);
            sta.setString(2,pass);
            sta.setInt(3,ID);
            sta.executeUpdate();
            System.out.println("普通用户注册成功");
        } catch (SQLException e) {
            System.out.println("普通用户注册失败");
            throw new RuntimeException(e);
        }
        sta.close();
        con.close();
    }


    //创建管理员
    public void insert_user_admin(String name,String pass,int ID) throws SQLException {
        try {
            String sql_insert="insert into user(userName,userPasswd,id,identity) values(?,?,?,2)";
            sta= con.prepareStatement(sql_insert);
            sta.setString(1,name);
            sta.setString(2,pass);
            sta.setInt(3,ID);
            sta.executeUpdate();
            System.out.println("管理员用户注册成功");
        } catch (SQLException e) {
            System.out.println("管理员用户注册失败");
            throw new RuntimeException(e);
        }
        sta.close();
        con.close();
    }


}
