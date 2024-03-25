package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.exception.InvalidIdException;
import com.model.Orders;
import com.model.Product;
import com.model.User;
import com.service.OrderService;
import com.service.UserService;

public class OrderManagement {

	public static void main(String[] args) throws SQLException, InvalidIdException {
		UserService userService = new UserService();
		OrderService orderService = new OrderService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("*****************CUSTOMER OPS ****************");
			System.out.println("Press 1 to Create Order");
			System.out.println("Press 2 to Cancel Order");
			System.out.println("Press 3 to Create User");
			System.out.println("Press 4 to Create Product");
			System.out.println("Press 5 to Fetch Product");
			System.out.println("Press 6 to Fetch Order By User");
			System.out.println("Enter 0 for exit");
			System.out.println("********************************************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Thank You !!!");
				break;
			}
			
			switch (input) {

			case 1:
				System.out.println("Enter your User Id ");
				int userId = sc.nextInt();
			try {
				User c = userService.validateUser(userId);
				List<Product> list2 = userService.fetchAllProducts();

				for (Product e : list2) {
					System.out.println(e.getProductId() + "   " + e.getProductName()+"   "+e.getDescription()+"    "+e.getQuantityInStock()+"    "+e.getPrice()+"    "+e.getType());
				}
				System.out.println("Give the Id of the Product you want to Buy ");
				int productId = sc.nextInt();
				System.out.println("Enter number of Product you want to Buy  ");
				int numOfItems = sc.nextInt();
				boolean productAvailable=userService.checkIfProductAvailable(list2,numOfItems,productId);
				if(!productAvailable) {
					System.out.println("Product Unavailable");
					break;
				}
				userService.insertOrder(productId,userId,numOfItems,list2);
				System.out.println("Order Created Successfully");
				userService.updateAvailableProduct(list2,productId,numOfItems);
				break;
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				
			}
			
			case 2:
				System.out.println("Enter user Id: ");
				int userId1=sc.nextInt();
				try {
				User c = userService.validateUser(userId1);
				if(c != null) {
				boolean x=userService.deleteOrder(userId1);
				if(!x) {
					System.out.println("Product not deleted");
				}
				System.out.println("Order Deleted");
				}
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
			
			case 3:
				System.out.println("Enter Name: ");
				String name=sc.nextLine();
				sc.nextLine();
				System.out.println("Enter Password: ");
				String password=sc.nextLine();
				sc.nextLine();
				System.out.println("Enter Role USER/ADMIN: ");
				String role=sc.nextLine();
				try {
				userService.insertUser(name,password,role);
				System.out.println("User Inserted Successfully ");
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
					
				}
				break;
				
			case 4:
				System.out.println("Enter Name: ");
				String name1=sc.nextLine();
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
				orderService.insertProduct(name1,description,price,quantity,type);
				System.out.println("User Inserted Successfully ");
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
					
				}
				
			case 5:
				List<Product> list2 = userService.fetchAllProducts();

				for (Product e : list2) {
					System.out.println(e.getProductId() + "   " + e.getProductName()+"   "+e.getDescription()+"    "+e.getQuantityInStock()+"    "+e.getPrice()+"    "+e.getType());
				}
				
			case 6:
				System.out.println("Enter User Id: ");
				int uid=sc.nextInt();
				User c = userService.validateUser(uid);
				
				List<Orders> list=orderService.getOrderDetails(uid);
				for (Orders e : list) {
					System.out.println(e.getProductId()+"     "+e.getUserId()+"     "+e.getQuantity()+"    "+e.getTotalPrice());
				}
				
				
			}

}
		sc.close();

	}

}
