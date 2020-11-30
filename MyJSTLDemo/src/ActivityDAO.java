import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.sql.*;
import mvc.bean.activityBean;

public class ActivityDAO {
	
	private Connection conn;

	 public ActivityDAO(Connection conn) {
			this.conn = conn;
	  }

	 
	  
	  public boolean insertActivity(activityBean Activity) {
	    try {
	      String sqlString = "insert into Activity Values('"
		                  	   	
								+ Activity.getArea()+"','"
								+ Activity.getActivity()+"','"
								+ Activity.getType()+"','"
								+ Activity.getDate_time_1()+"','"
								+ Activity.getDate_time_2()+"','" 
								+ Activity.getDay()+"','"
								+ Activity.getAddress()+"','"
	                            + Activity.getLocation()+"','"
	                            + Activity.getAddress()+ "'"
	                            + Activity.getLimit_per()+"','"
	                            + Activity.getCost()+"')";
	                           
	      Statement stmt = conn.createStatement();
	      System.out.println(sqlString);
		  int updatecount = stmt.executeUpdate(sqlString);
	      stmt.close();
	      if (updatecount >= 1) return true;
	      else                  return false;
		  } catch (Exception e) {
			  System.out.println(e);
		    System.err.println("資訊錯誤" + e);
			  return false;
	    }
	  }


	}
