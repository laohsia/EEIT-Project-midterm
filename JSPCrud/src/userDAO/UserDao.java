package userDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import userBean.User;
public class UserDao {
public static Connection getConnection(){
	Connection con=null;
	try{
		
		String url ="jdbc:sqlserver://localhost:1433;databaseName=MD2";
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con=DriverManager.getConnection(url,"scott","tiger");
		
	}catch(Exception e){System.out.println(e);}
	return con;
}
public static int insert(User u){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps = con.prepareStatement("insert into Member (account,password,name,gender,birthday,phone,mailaddress) values(?,?,?,?,?,?,?)");
		ps.setString(1,u.getAccount());
		ps.setString(2,u.getPassword());
		ps.setString(3,u.getName());
		ps.setString(4,u.getGender());
		ps.setString(5,u.getBirthday());
		ps.setString(6,u.getPhone());
		ps.setString(7,u.getMailaddress());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int update(User u){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("update Member set password=?,name=?, gender=?, birthday=?, phone=?, mailaddress=? where account= ?");
		ps.setString(1,u.getPassword());
		ps.setString(2,u.getName());
		ps.setString(3,u.getGender());
		ps.setString(4,u.getBirthday());
		ps.setString(5,u.getPhone());
		ps.setString(6,u.getMailaddress());
		ps.setString(7,u.getAccount());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}
	return status;
}

public static int delete(User u){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("delete from Member where account=?");
		ps.setString(1,u.getAccount());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}

	return status;
}
public static List<User> getAllRecords(){
	List<User> list=new ArrayList<User>();
	
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from Member");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			User u=new User();
			u.setAccount(rs.getString("account"));
			u.setPassword(rs.getString("password"));
			u.setName(rs.getString("name"));
			u.setGender(rs.getString("gender"));
			u.setBirthday(rs.getString("birthday"));
			u.setPhone(rs.getString("phone"));
			u.setMailaddress(rs.getString("mailaddress"));
			list.add(u);
		}
	}catch(Exception e){System.out.println(e);}
	return list;
}
public static User getRecordById(String account){
	User u=null;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from Member where account= ?");
		System.out.println(account);
		ps.setString(1,account);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			u=new User();
			u.setAccount(rs.getString("account"));
			u.setPassword(rs.getString("password"));
			u.setName(rs.getString("name"));
			u.setGender(rs.getString("gender"));
			u.setBirthday(rs.getString("birthday"));
			u.setPhone(rs.getString("phone"));
			u.setMailaddress(rs.getString("mailaddress"));
		}
	}catch(Exception e){System.out.println(e);}
	return u;
}
}
