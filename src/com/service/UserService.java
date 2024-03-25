package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.OrdersDao;
import com.dao.OrdersDaoImpl;
import com.exception.InvalidIdException;
import com.model.Product;
import com.model.User;

public class UserService {
	
	OrdersDao ordersdao=new OrdersDaoImpl();
	int userId1;
	public User validateUser(int userId) throws InvalidIdException, SQLException {
		return ordersdao.validateCustomer(userId);
		
	}

	public List<Product> fetchAllProducts() throws SQLException {
		return ordersdao.fetchAllProducts();// TODO Auto-generated method stub
		
	}

	public boolean checkIfProductAvailable(List<Product> list2, int numOfItems, int productId) {
		for (Product e:list2) {
			if(e.getProductId()==productId) {
				if(e.getQuantityInStock()>=numOfItems) {
					return true;
				}
			}
		}
		return false;
	}

	public void insertOrder(int productId, int userId, int numOfItems, List<Product> list2) throws SQLException {
		double totalPrice=0;
		for (Product e:list2) {
			if(e.getProductId()==productId) {
				totalPrice=(e.getPrice()*numOfItems);
				break;
			}
		}
		ordersdao.insertOrder(productId,userId,numOfItems,totalPrice );
		
	}

	public void updateAvailableProduct(List<Product> list2, int productId, int numOfItems) throws SQLException {
		for (Product e:list2) {
			if(e.getProductId()==productId) {
				ordersdao.updateAvailableProduct(productId,(e.getQuantityInStock()-numOfItems));
			}
		}
		
	}

	public boolean deleteOrder(int userId1) throws SQLException {
		this.userId1=userId1;
		return ordersdao.deleteOrder(userId1);
		
	}

	public void insertUser(String name, String password, String role) throws SQLException {
		ordersdao.insertUser(name,password,role);
		
	}

	
	

}
