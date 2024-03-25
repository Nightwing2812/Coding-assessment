package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.exception.InvalidIdException;
import com.model.Product;
import com.model.User;
import com.service.UserService;


public class UserController {

	public static void main(String[] args) throws InvalidIdException, SQLException {
		UserService userService = new UserService();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("*****************CUSTOMER OPS ****************");
			System.out.println("Press 1 to Create Order");
			System.out.println("Press 2 to Cancel Order");
			System.out.println("Press 3 to Create User");
			System.out.println("Enter 0 for exit");
			System.out.println("********************************************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Thank You !!!");
				break;
			}
			
			switch (input) {

			case 1:
				System.out.println("Enter your Customer Id ");
				int userId = sc.nextInt();
			try {
				User c = userService.validateUser(userId);
				List<Product> list2 = userService.fetchAllProducts();

				for (Product e : list2) {
					System.out.println(e.getProductId() + "   " + e.getProductName()+"   "+e.getDescription()+"    "+"Available stock   "+e.getQuantityInStock()+"Price/product"+"   "+e.getPrice());
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
				System.out.println("Ticket Booked Successfully");
				userService.updateAvailableProduct(list2,productId,numOfItems);
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
				}}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
			
			case 3:
				
				
				
				
				

	}

}
		sc.close();
		
	
}
}

