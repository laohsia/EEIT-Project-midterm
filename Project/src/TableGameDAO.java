// DAO: Database Access Object
// 專責與Dept Table之新增,修改,刪除與查詢

import java.sql.*;

public class TableGameDAO {

  private Connection conn;

  //建構子
  public TableGameDAO(Connection conn) {
		this.conn = conn;
  }

  //建立新的部門
//  public int createGame(String E_name, String C_name) {
//    try {
//
//	    String sqlString = "SELECT dept_id.nextval FROM DUAL";
//  	  Statement stmt = conn.createStatement();
//  	  //自取號機取得新部門的部門代號
//	    ResultSet rs = stmt.executeQuery(sqlString);
//
//      if (rs.next()) deptno = rs.getInt(1);
//
//      rs.close();
//
//    //新增部門到Dept Table
//      sqlString = "INSERT INTO dept(deptno,dname) " +
//	                "VALUES(" + deptno + ",'" + dname + "')";
//      stmt.executeUpdate(sqlString);
//  	  stmt.close();
//	    return deptno;
//	  } catch (Exception e) {
//	    System.err.println("建立部門時發生錯誤:" + e);
//		  return -1;
//	  }
//  }

  //刪除部門
//  public boolean deleteGame(int deptno) {
//    try {
//      String sqlString = "DELETE FROM dept " +
//			                   "WHERE deptno = " + deptno;
//	    Statement stmt = conn.createStatement();
//		  int deletecount = stmt.executeUpdate(sqlString);
//		  stmt.close();
//      if (deletecount >= 1) return true;
//		  else                  return false;
//	  } catch (Exception e) {
//	    System.err.println("刪除部門時發生錯誤: "+ e);
//		  return false;
//	  }
//  }

  //更新部門資料
//  public boolean updateDept(TableGame deptData) {
//    try {
//      String sqlString = "UPDATE dept " +
//	                  	   	 "SET dname = '" + deptData.getDname() +"' "+ 
//                    			 "WHERE deptno = " + deptData.getDeptno();
//
//      Statement stmt = conn.createStatement();
//	    int updatecount = stmt.executeUpdate(sqlString);
//      stmt.close();
//      if (updatecount >= 1) return true;
//      else                  return false;
//	  } catch (Exception e) {
//	    System.err.println("更新部門資料時發生錯誤:" + e);
//		  return false;
//    }
//  }

  //尋找部門資料
  public TableGame findGame(String C_name) {
    try {
      TableGame g1 = null;
      String E_name;
	   

      Statement stmt = conn.createStatement();
      String sqlString = "SELECT E_name " +
	       			  "FROM product WHERE C_name = " + C_name;
      
	  ResultSet rs = stmt.executeQuery(sqlString);

      if (rs.next()) {
        E_name  =  rs.getString("E_name");
		g1 = new TableGame(E_name,C_name);
	  }
	  rs.close();
	  stmt.close();
	  return g1;
	  
    } catch (Exception e) {
	    System.err.println("尋找遊戲資料時發生錯誤:" + e);
	    return null;
    }
	}

}