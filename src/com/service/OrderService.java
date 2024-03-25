package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.IOrdersManagementRepositorydao;
import com.dao.IOrdersManagementRepositorydaoImpl;
import com.model.Orders;

public class OrderService {
	IOrdersManagementRepositorydao orderManagement=new IOrdersManagementRepositorydaoImpl();

	public void insertProduct(String name, String description, double price, int quantity, String type) throws SQLException {
		orderManagement.insertProduct(name,description,price,quantity,type);
	}

	public List<Orders> getOrderDetails(int uid) throws SQLException {
		return orderManagement.getOrderDetails(uid);
		
		
	}
	
	
	
	
	
	}

