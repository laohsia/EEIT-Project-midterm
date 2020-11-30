import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class ActivityJBDCDAO implements ActivityDAO{
	
	private BasicDataSource dataSource;
	
	public BasicDataSource getDataSource() {
		if(dataSource == null) {
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ds.setUrl("jdbc:sqlserver://localhost:1433;databaseName=MD2");
			ds.setUsername("scott");
			ds.setPassword("tiger");
			ds.setMaxIdle(50); //最多可以在pool中發呆的連線數
			ds.setMaxTotal(50); //最多能同時間保留的連線數		
			dataSource = ds;
		}
		return dataSource;
	}
	@Override
	public List<Activity> listActivitys() {
		// TODO Auto-generated method stub

		List<Activity>list = new ArrayList<>();
		try (Connection con = getDataSource().getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Activity");){
				while(rs.next()) {
				Activity act = new Activity();
				act.setArea(rs.getString("area"));
				act.setActivity(rs.getString("activity"));
				act.setType(rs.getString("type"));
				act.setDate_time_1(rs.getTimestamp("date_time_1"));
				act.setDate_time_2(rs.getTimestamp("date_time_2"));
				act.setDay(rs.getInt("day"));
				act.setLocation(rs.getString("location"));
				act.setAddress(rs.getNString("address"));
				act.setLimit_per(rs.getInt("limit_per"));
				act.setCost(rs.getInt("cost"));
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
			
		return list;
	
		}
	@Override
	public void updateActivity(Activity activity) {
		// TODO Auto-generated method stub
		try(Connection connection = getDataSource().getConnection();){
			PreparedStatement pstmt = connection.prepareStatement
					("update act set area=?, activity=?,type=?,date_time_1=?,date_time_2=?,day=?,location=?, address=?,limit_per=?, cost=?");
			pstmt.setString (1,activity.getArea());
			pstmt.setString(2, activity.getActivity());
			pstmt.setString(3, activity.getType());
			pstmt.setTimestamp(4, activity.getDate_time_1());
			pstmt.setTimestamp(5, activity.getDate_time_2());
			pstmt.setInt(6, activity.getDay());
			pstmt.setString(7, activity.getLocation());
			pstmt.setString(8, activity.getAddress());
			pstmt.setInt(9, activity.getLimit_per());
			pstmt.setInt(10, activity.getCost());
			pstmt.execute();
			
			}catch (SQLException e) {
			e.printStackTrace();
			}
		}
		
		@Override
		public void creatActivity(Activity activity) {
			try(Connection connection = getDataSource().getConnection();){
				PreparedStatement pstmt = connection.prepareStatement
						("insert into Activity(area, activity, type, date_time_1, date_time_2, day, location, address, limit_per, cost)values(?, ?, ?, ?, ?,?, ?, ?, ?, ?)");
				ResultSet rs = pstmt.executeQuery();

				rs.next();
				pstmt.setString(1,activity.getArea());
				pstmt.setString(2,activity.getActivity());
				pstmt.setString(3,activity.getType());
				pstmt.setTimestamp(4,activity.getDate_time_1());
				pstmt.setTimestamp(5,activity.getDate_time_2());
				pstmt.setInt(6, activity.getDay());
				pstmt.setString(7, activity.getLocation());
				pstmt.setString(8, activity.getAddress());
				pstmt.setInt(9, activity.getLimit_per());
				pstmt.setInt(10, activity.getCost());
				pstmt.execute();

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}


