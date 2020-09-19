package dao;

import java.sql.*;

public class BaseDao {
	protected Connection conn;
	protected PreparedStatement pstm;
	protected ResultSet rs;
	public Connection getCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("鏁版嵁搴撻┍鍔ㄥ姞杞藉畬鎴�");
			String url="jdbc:mysql://localhost:3306/cabb?useUnicode=true&characterEncoding=UTF-8";
			String username="root";
			String password="111";
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return conn;		
	}
	
	public void closeAll() {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstm!=null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int executUpdate(String sql,Object[] o) {
		 conn = this.getCon();
		 int num=0;
		 try {
			pstm =conn.prepareStatement(sql);
			for (int i = 0; i < o.length; i++) {
				pstm.setObject(i+1, o[i]);
			}
			num = pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;		
	}
	
	public ResultSet  executeQuery(String sql,Object[] o) {
		conn=this.getCon();
		 int num=0;
		try {
			pstm=conn.prepareStatement(sql);
			if (o!=null) {
				for (int i = 0; i < o.length; i++) {
					pstm.setObject(i+1, o[i]);
				}
			}
			
		   rs=pstm.executeQuery();
		   
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return rs;
		
	}
}
