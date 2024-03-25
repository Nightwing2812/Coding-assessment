package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.util.DBUtil;

public class IOrdersManagementRepositorydaoImpl implements IOrdersManagementRepositorydao{
	
	public void insertProduct(String name, String description, double price, int quantity, String type) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="insert into product(productname,description,price,quantityinstock,type) values(?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,name);
		pstmt.setString(2,description);
		pstmt.setDouble(3,price);
		pstmt.setInt(4,quantity);
		pstmt.setString(5,type);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}

}
