package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Orders;
import com.model.Product;
import com.model.User;
import com.service.OrderService;
import com.service.UserService;

public class OrdersController {
	public static void main(String[] args) throws SQLException {
		OrderService orderService = new OrderService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("*****************CUSTOMER OPS ****************");
			System.out.println("Press 1 to Create Product");
			System.out.println("Press 2 to Fetch Product");
			System.out.println("Press 3 to Fetch Order By User");
			System.out.println("Enter 0 for exit");	
			System.out.println("********************************************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Thank You !!!");
				break;
			}
			switch(input) {
			case 1:
				System.out.println("Enter Name: ");
				String name=sc.nextLine();
				sc.nextLine();
				System.out.println("Enter Description: ");
				String description=sc.nextLine();
				System.out.println("Enter Price: ");
				double price=sc.nextDouble();
				System.out.println("Enter Quantity: ");
				int quantity=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Type ");
				String type=sc.nextLine();

				try {
				orderService.insertProduct(name,description,price,quantity,type);
				System.out.println("User Inserted Successfully ");
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
					
				}
				
			case 2:
				UserService userService = new UserService();
				List<Product> list2 = userService.fetchAllProducts();

				for (Product e : list2) {
					System.out.println(e.getProductId() + "   " + e.getProductName()+"   "+e.getDescription()+"    "+e.getQuantityInStock()+"    "+e.getPrice()+"    "+e.getType());
				}
				
			case 3:
				System.out.println("Enter User Id: ");
				int uid=sc.nextInt();
				User c = userService.validateUser(uid);
				
				List<Orders> list=new orderService.getOrderDetails(uid);
				for (Orders e : list) {
					System.out.println(e.getProductId()+"     "+e.getUserId()+"     "+e.getQuantity()+"    "+e.getTotalPrice());
				}
				
			
	}
			}
		sc.close();
	}
}
