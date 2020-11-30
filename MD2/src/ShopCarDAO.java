import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShopCarDAO {
	private Connection conn;
	
	public ShopCarDAO(Connection conn) {
		this.conn = conn;
	}
	public ResultSet select(String Do) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Do);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean delete(String Do) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(Do);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		}
	public boolean insert(String Do) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(Do);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean updata(String Do) {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(Do);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
