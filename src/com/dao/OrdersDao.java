package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.InvalidIdException;
import com.model.Product;
import com.model.User;

public interface OrdersDao {

	public User validateCustomer(int userId) throws InvalidIdException, SQLException;
	
	public List<Product> fetchAllProducts() throws SQLException;
	
	public void insertOrder(int productId, int userId, int numOfItems, double totalPrice)throws SQLException;
	
	public void updateAvailableProduct(int productId, int i) throws SQLException;

	public boolean deleteOrder(int userId1) throws SQLException;

	public void insertUser(String name, String password, String role) throws SQLException;
	
	

}
