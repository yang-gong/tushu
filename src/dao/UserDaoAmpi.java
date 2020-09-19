package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class UserDaoAmpi extends BaseDao implements UserDao {

	@Override
	public int adduser(User user) {
		Object [] o = {user.getUsername(),user.getPassword()}; 
		int num=this.executUpdate("insert into user (username,password) values (?,?) ", o);
		this.closeAll();
		return num;
	}

	@Override
	public boolean QueryUser(String username) {
		Object [] o = {username};
		boolean b=true;
		ResultSet rs=this.executeQuery("select * from user where username=?", o);
		try {
			b=rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean QueryUserByUser(User user) {
		Object [] o = {user.getUsername(),user.getPassword()}; 
		boolean b=true;
		ResultSet rs=this.executeQuery("select * from user where username=? and password=?", o);
		try {
			b=rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

}
