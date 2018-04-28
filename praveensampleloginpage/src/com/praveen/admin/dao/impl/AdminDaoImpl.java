package com.praveen.admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.praveen.admin.dao.AdminDao;
import com.praveen.util.DBFactory;

public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean validateAdmin(String userName, String password) {
		String sql="select * from admin where uname=? and password=?";
		boolean isExist=false;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try(Connection con=DBFactory.getConnection();) {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2,password);
			rs=pstmt.executeQuery();
			if (rs.next()) {
				isExist=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return isExist;

	}

}
