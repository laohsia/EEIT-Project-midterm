import java.text.*;
import java.util.*;

import mvcdemo.bean.LoBean;

import java.sql.*;

public class LoDAO {
	  static Connection conn = null;
      static ResultSet rs = null;  
		
      public static LoBean login(LoBean bean) {
	
         Statement stmt = null;    
	
         String account = bean.getAccount();    
         String password = bean.getPassword();   
	    
         String SqlQuery =
               "select * from Member where account='"
                        + account
                        + "' AND password='"
                        + password
                        + "'";
	    
      System.out.println("Your user name is " + account);          
      System.out.println("Your password is " + password);
      System.out.println("Query: "+SqlQuery);
	    
      try 
      {
         conn = ConnectionManager.getConnection();
         stmt=conn.createStatement();
         rs = stmt.executeQuery(SqlQuery);	        
         boolean more = rs.next();
	       
         // if user does not exist set the isValid variable to false
         if (!more) 
         {
            System.out.println("Sorry, you are not a registered user! Please sign up first");
            bean.setValid(false);
         } 
	        
         //if user exists set the isValid variable to true
         else if (more) 
         {
            String Name = rs.getString("name");
	     	
            System.out.println("Welcome " + Name);
            bean.setName(Name);
            bean.setValid(true);
         }
      } 

      catch (Exception ex) 
      {
         System.out.println("Log In failed: An Exception has occurred! " + ex);
      } 
	    
      //some exception handling
      finally 
      {
         if (rs != null)	{
            try {
               rs.close();
            } catch (Exception e) {}
               rs = null;
            }
	
         if (stmt != null) {
            try {
               stmt.close();
            } catch (Exception e) {}
               stmt = null;
            }
	
         if (conn != null) {
            try {
            	conn.close();
            } catch (Exception e) {
            }

            conn = null;
         }
      }

return bean;
	
      }	
}
