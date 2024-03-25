package com.service;

import java.sql.SQLException;
import com.dao.IOrdersManagementRepositorydao;

public class OrderService {

	public void insertProduct(String name, String description, double price, int quantity, String type) throws SQLException {
		IOrdersManagementRepositorydao.insertProduct(name,description,price,quantity,type);
	}
	
	
	
	
	
	}

