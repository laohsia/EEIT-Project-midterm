import java.sql.*;
import mvc.bean.regisBean;

public class RegisDAO {

	 private Connection conn;


	  public RegisDAO(Connection conn) {
			this.conn = conn;
	  }

	 
	  
	  public boolean insertRegis(regisBean regisData) {
	    try {
	      String sqlString = "insert into registerData values('"
		                  	   	
								+ regisData.getLocation()+"','"
								+ regisData.getName()+"','"
								+ regisData.getBirthyear()+"','"
								+ regisData.getBirthmonth()+"','"
								+ regisData.getBirthday()+"','" 
								+ regisData.getId()+"','"
								+ regisData.getAddress()+"','"
	                            + regisData.getPhone()+"','"
	                            + regisData.getMailaddress()+ "')";
	                           
	      Statement stmt = conn.createStatement();
	      System.out.println(sqlString);
		  int updatecount = stmt.executeUpdate(sqlString);
	      stmt.close();
	      if (updatecount >= 1) return true;
	      else                  return false;
		  } catch (Exception e) {
			  System.out.println(e);
		    System.err.println("�s�W�ǥ͸�Ʈɵo�Ϳ��~:" + e);
			  return false;
	    }
	  }


	}
