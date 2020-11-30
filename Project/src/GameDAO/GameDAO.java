package GameDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.classfile.LocalVariableTable;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.sun.xml.internal.fastinfoset.util.ValueArrayResourceException;

import ProjectBean.GameBean;


public class GameDAO {

	private static Connection conn;

	// 建構子
	public GameDAO(Connection conn) {
		this.conn = conn;
	}

	// 確認遊戲是否存在
	public boolean checkGame(String C_name) {
		try {
			String sql = "select c_name from product where c_name = N'" + C_name+"'";
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return true;
			} else {

				return false;
			}
		} catch (Exception e) {
			System.err.println("確認遊戲時發生錯誤:" + e);
			return false;
		}

	}

	
	//搜尋遊戲並印出資料(多筆)
	public static ResultSet SearchGame(String C_name) {
		
		try {
			String sql = "select * from product where c_name like N'%" + C_name+"%'";
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
			
		} catch (Exception e) {
			System.err.println("搜尋遊戲時發生錯誤:" + e);
			//System.out.println("查無資料");
		}
		return null;

	}
	
public ResultSet SearchGame(String C_name, String E_name) {
		
		try {
			String sql = "select * from product where c_name like N'%" + C_name+"%' and e_name = N'"+E_name+"'" ;
			System.out.println(sql);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
			
		} catch (Exception e) {
			System.err.println("搜尋遊戲時發生錯誤:" + e);
			//System.out.println("查無資料");
		}
		return null;

	}




	// 建立新的遊戲
	public boolean createGame(GameBean Gamedata) {
		try {
			String sql = "insert into Product (E_name,C_name,img_url,G_maker,iss,info,Price) values('"
					+ Gamedata.getE_name() + "','" + Gamedata.getC_name() + "','" + Gamedata.getImg_url() + "','"
					+ Gamedata.getG_maker() + "','" + Gamedata.getIss() + "','" + Gamedata.getInfo() + "','"
					+ Gamedata.getPrice() + "')";
			System.out.println(sql);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int result = pstmt.executeUpdate();
			if (result >= 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.err.println("建立遊戲時發生錯誤:" + e);
			return false;
		}
	}
	
	//刪除遊戲
	public boolean deleteGame(String C_name) {
		try {
			String sql="delete from product where c_name = N'"+C_name+"'";
			System.out.println(sql);
			Statement stmt=conn.createStatement();
			int result=stmt.executeUpdate(sql);
			if(result !=0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			System.err.println("刪除遊戲時發生錯誤:" + e);
			return false;
		}
	}
	
	//更新遊戲資訊
	public boolean updateGame(GameBean Gamedata) {
		try {
			String sql="update product set E_name ='"+Gamedata.getE_name()+"',img_url='"+Gamedata.getImg_url()+"',G_maker='"+Gamedata.getG_maker()+"',iss='"
					+Gamedata.getIss()+"',info='"+Gamedata.getInfo()+"',Price='"+Gamedata.getPrice()+"' where c_name='"+Gamedata.getC_name()+"'";
			System.out.println(sql);
			Statement stmt=conn.createStatement();
			int result =stmt.executeUpdate(sql);
			if(result!=0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			System.err.println("更新遊戲資訊時發生錯誤:" + e);
			return false;
		}
		
	}
}
	


