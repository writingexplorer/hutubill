package util;
import java.sql.*;

public class DBUtil {
   static String ip="127.0.0.1";
   static int port=3306;
   static String database="hutubill1";
   static String encoding="UTF-8";
   static String loginName="root";
   static String passport="admin";
   static {
	   try {
		   Class.forName("com.mysql.jdbc.Driver");
	   }catch(ClassNotFoundException e) {
		   e.printStackTrace();
	   }
   }
   public static Connection getConnection() throws SQLException{
	  
	   String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
       return DriverManager.getConnection(url, loginName, passport);
   }
}
