package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Orders;

public interface IOrdersManagementRepositorydao {

	public void insertProduct(String name, String description, double price, int quantity, String type) throws SQLException;

	public List<Orders> getOrderDetails(int uid) throws SQLException;

}
