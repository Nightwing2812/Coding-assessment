package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Orders;
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
	
	public List<Orders> getOrderDetails(int uid) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		List<Orders> list = new ArrayList<>();
		String sql = "select * from orders where userId=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, uid);
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) { 
			int productId = rst.getInt("productId");
			int userId = rst.getInt("userId");
			int quantity = rst.getInt("quantity");
			int totalPrice= rst.getInt("totalPrice");
			
			Orders od = new Orders(productId,userId,quantity,totalPrice);
			list.add(od);
		}
		DBUtil.dbClose();
		return list;
		
	}

}
