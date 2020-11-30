package boardgames;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.storeconfig.StandardHostSF;
import org.apache.tomcat.jdbc.pool.DisposableConnectionFacade;

public class disDAO {
	private Connection conn;

	public disDAO(Connection conn) {
		this.conn = conn;
	}

	public ResultSet select() {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select* from DiscussionBoard");
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean insertcomment(setdis setdis) throws SQLException // Create
	{
		String sql = " Insert INTO DiscussionBoard (id, name, comment, date) Values(?,?,?,?)";
		conn();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setNString(1, setdis.getid());
		statement.setNString(2, setdis.getname());
		statement.setNString(3, setdis.getcomment());
		statement.setNString(4, setdis.getDate());

		boolean rowInserted = (statement.executeUpdate() > 0);
		statement.close();
		disconnect();

		return rowInserted;
	}

	public List<setdis> listAllComments() throws SQLException // Read
	{
		List<setdis> listcomment = new ArrayList<>();
		String sql = " select * from DiscussionBoard";
		conn();
		Statement statement = conn.createStatement();
		ResultSet rSet = statement.executeQuery(sql);

		while (rSet.next()) {
			String id = rSet.getNString("id");
			String name = rSet.getNString("name");
			String comment = rSet.getNString("comment");
			String date = rSet.getNString("date");

			setdis setdis = new setdis(id, name, comment, date);
			listcomment.add(setdis);
		}
		rSet.close();
		statement.close();
		disconnect();
		return listcomment;

	}

	public boolean deletecomment(setdis setdis) throws SQLException // Delete
	{
		String sql = "Delete from DiscussionBoard where id = ?";
		conn();

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setNString(1, setdis.getid());

		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;

	}

	public boolean updatecomment(setdis setdis) throws SQLException // Update
	{
		String sql = " UPDATE  DiscussionBoard set comment = ? ";
		sql += "Where id = ?";
		conn();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setNString(1, setdis.getcomment());
		statement.setNString(2, setdis.getid());

		boolean rowUpdate = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdate;

	}

	private void disconnect() {
		conn = null;

	}

	private void conn() {
		// TODO Auto-generated method stub

	}

}
