package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.InvalidIdException;
import com.model.Product;
import com.model.User;
import com.util.DBUtil;

public class OrdersDaoImpl implements OrdersDao {
	
	public User validateCustomer(int userId) throws SQLException, InvalidIdException {
		Connection conn=DBUtil.getDBConn();
		User c=new User();
		String sql="select * from user where userId=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, userId);
		ResultSet rst=pstmt.executeQuery();
		if(rst.next()) {
			int id=rst.getInt("userId");
			c.setUserId(id);
			return c;
		}

		DBUtil.dbClose();

		throw new InvalidIdException("Invalid customer Id");

		
	}
	
	public List<Product> fetchAllProducts() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getDBConn();
		List<Product> list = new ArrayList<>();
		String sql = "select * from product";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) { 
			int ProductId= rst.getInt("productId");
			String Productname = rst.getString("productName");
			String Description = rst.getString("description");
			Double price = rst.getDouble("price");
			int quantityInStock= rst.getInt("quantityInStock");
			String type = rst.getString("type");
			
			Product pd = new Product(ProductId,Productname,Description,price,quantityInStock,type);
			list.add(pd);
		}
		DBUtil.dbClose();
		return list;
	}
	
	public void insertOrder(int productId, int userId, int numOfItems, double totalPrice) throws SQLException {
		Connection conn=DBUtil.getDBConn();

		String sql="insert into orders(productId,userId,quantity,totalPrice) values(?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1,productId);
		pstmt.setInt(2,userId);
		pstmt.setInt(3,numOfItems);
		pstmt.setDouble(4,totalPrice);
		pstmt.executeUpdate();
	
		DBUtil.dbClose();
		
	}	
	
	public void updateAvailableProduct(int productId, int i) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="update product set quantityInStock=? where productId=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1,i);
		pstmt.setInt(2, productId);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
		
	}
	
	public boolean deleteOrder(int userId1) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="DELETE FROM Orders WHERE userId = ?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1,userId1);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
		return true;
		
		}
	
	public void insertUser(String name, String password, String role) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		String sql="insert into user (userName,password,role) values(?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,name);
		pstmt.setString(2,password);
		pstmt.setString(3,role);
		pstmt.executeUpdate();
		
		DBUtil.dbClose();
	}
	

	

	



}
