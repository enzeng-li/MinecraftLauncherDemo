package Data_Con;

import java.sql.PreparedStatement;

public class connection {
    private static String jdbcName ="com.mysql.cj.jdbc.Driver";
    private static String url ="jdbc:mysql://localhost:3306/player_management";
    //user名为指定的数据库
    private static String user="root";
    private static String password="lienzeng";
    private java.sql.Connection con;
    private PreparedStatement sta;
    public connection(){

    }

}
