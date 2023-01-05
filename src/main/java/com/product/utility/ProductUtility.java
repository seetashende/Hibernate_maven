package com.product.utility;

import java.util.Scanner;

import com.product.entity.Product;

public class ProductUtility {
public  static Product prepareproductdata(Scanner scanner) {
	System.out.println("Enter the Product Id");
	int ProductId=scanner.nextInt();
	System.out.println("Enter the Product name");
	String ProductName=scanner.next();
	System.out.println("Enter the Product price");
	double ProductPrice=scanner.nextDouble();
	System.out.println("Enter the Product mfg");
	String ProductMfg= scanner.next();
	System.out.println("Enter the Product category");
	String ProductCategory=scanner.next();
	Product product= new Product(ProductId, ProductName, ProductPrice, ProductMfg, ProductCategory);
	return product;
	
	
}
}
