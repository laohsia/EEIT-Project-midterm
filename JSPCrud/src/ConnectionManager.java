import java.sql.*;
import java.util.*;

public class ConnectionManager {
	static Connection con;
    static String url;
          
    public static Connection getConnection()
    {
      
       try
       {
          String url ="jdbc:sqlserver://localhost:1433;databaseName=MD2"; 
          // assuming "DataSource" is your DataSource name

          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
          try
          {            	
             con = DriverManager.getConnection(url,"scott","tiger"); 
              								
          // assuming your SQL Server's	username is "username"               
          // and password is "password"
               
          }
          
          catch (SQLException ex)
          {
             ex.printStackTrace();
          }
       }

       catch(ClassNotFoundException e)
       {
          System.out.println(e);
       }

    return con;
}
}
