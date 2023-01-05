package com.productr;

import java.util.List;
import java.util.Scanner;

import com.product.entity.Product;
import com.product.service.ProductService;
import com.product.utility.ProductUtility;

public class Test {
public static void main(String[] args) {
	Scanner scanner= new Scanner(System.in);
	ProductService service=new ProductService();
	int choice ;
	char ch;
	do {
		System.out.println("press 1 save product");
		System.out.println("press 2 get product");
		System.out.println("press 3 delete product");
		System.out.println("press 4 update product");
		System.out.println("press 5 getAll product");
		System.out.println("press 6 getAllProductAscendingOrder");
		System.out.println("press 7 getAllProductDescendingOrder");
		System.out.println("press 8 getpaginationData");
		System.out.println("press 9 RestrictionExample");
		System.out.println("press 10 RestrictionExBetween");
		System.out.println("press 11 RestrictionExLessthan");
		System.out.println("press 12 RestrictionExGreaterthan");
		System.out.println("press 13 RestrictionExGreaterthanEqual");
		System.out.println("press 14 RestrictionExAllEqual");
		System.out.println("press 15 RestrictionExInMethod");
		System.out.println("press 16 RestrictionExLike");
		System.out.println("press 17 projectionssum");
		System.out.println("press 18 projectionsavg");
		System.out.println("press 19 projectionsmax");
		System.out.println("press 20 projectionsmin");
		
		
		choice= scanner.nextInt();
		switch (choice) {
		case 1:{
			
		Product product=ProductUtility.prepareproductdata(scanner);
		String msg=	service.savepProduct(product);
		System.out.println(msg);
			break;
		}
		case 2:{
		System.out.println("Enter the Id");  
        int ProductId = scanner.nextInt();
       Product product =service.getProductById(ProductId);
       if(product!=null) {
    	   System.out.println(product);
       }
       else 
       {
    	   System.out.println("product not found");
       }
			break;
        }
        
		case 3:{
			System.out.println("Enter the Id");
			int ProductId= scanner.nextInt();
			String msg =service.deleteProductById(ProductId);
			System.out.println(msg);
			
			break;
			
        }
        case 4:{
        
        	Product product=ProductUtility.prepareproductdata(scanner);
        	 String msg =service.updateproduct(product);
        	 System.out.println(msg);
        	break;
        }
        
        case 5:{;
        	
        	List<Product> list= service.getAllProducts();
        	if(!list.isEmpty()) {
        		for (Product product : list) {
					System.out.println(product);
				}
        	}
        	else
        	{
        		System.out.println("product not exist ");
        	}
        	break;
        }
        
        case 6:{
        	List<Product> list= service.getAllProductAscendingOrder();
        	if(!list.isEmpty()) {
        		for (Product product : list) {
					System.out.println(product);
				}
        	}
        	else
        	{
        		System.out.println("product not exist ");
        	}
        	break;
        }
        	
        case 7 :{
        	List<Product> list= service.getAllProductDescendingOrder();
        	if(!list.isEmpty()) {
        		for (Product product : list) {
					System.out.println(product);
				}
        	}
        	else
        	{
        		System.out.println("product not exist ");
        	}
        	break;
        }
        
        case 8:{
        	List<Product> list= service.getPaginationData();
        	if(!list.isEmpty()) {
        		for (Product product : list) {
					System.out.println(product);
				}
        	}
        	else
        	{
        		System.out.println("product not exist ");
        	}
        	break;
        }
        case 9:{
        	
        List<Product> list = service.RestrictionExample();
    	if  (!list.isEmpty()) {
    		for (Product product : list) {
				System.out.println(product);
			}
    	}
    	else
    	{
    		System.out.println("product not exist ");
    	}
    	break;
        	
        }
        
        case 10:{
        	List<Product> list = service.RestrictionExBetween();
        	if  (!list.isEmpty()) {
        		for (Product product : list) {
    				System.out.println(product);
    			}
        	}
        	else
        	{
        		System.out.println("product not exist ");
        	}
        	break;
        }
        	case 11:{
        		List<Product> list = service.RestrictionExLessthan();
            	if  (!list.isEmpty()) {
            		for (Product product : list) {
        				System.out.println(product);
        			}
            	}
            	else
            	{
            		System.out.println("product not exist ");
            	}
            	break;
        	}
        	case 12:{
        		List<Product> list = service.RestrictionExGreaterthan();
            	if  (!list.isEmpty()) {
            		for (Product product : list) {
        				System.out.println(product);
        			}
            	}
            	else
            	{
            		System.out.println("product not exist ");
            	}
            	break;
        	}
        	case 13:{
        		List<Product> list = service.RestrictionExGreaterthanEqual();
            	if  (!list.isEmpty()) {
            		for (Product product : list) {
        				System.out.println(product);
        			}
            	}
            	else
            	{
            		System.out.println("product not exist ");
            	}
            	break;
        	}
        	case 14:{
        		List<Product> list = service.RestrictionExAllEqual();
            	if  (!list.isEmpty()) {
            		for (Product product : list) {
        				System.out.println(product);
        			}
            	}
            	else
            	{
            		System.out.println("product not exist ");
            	}
            	break;
        	}
        	case 15:{
        		List<Product> list = service.RestrictionExInMethod();
            	if  (!list.isEmpty()) {
            		for (Product product : list) {
        				System.out.println(product);
        			}
            	}
            	else
            	{
            		System.out.println("product not exist ");
            	}
            	break;
        	}
        	case 16:{
        		List<Product> list = service.RestrictionExLike();
            	if  (!list.isEmpty()) {
            		for (Product product : list) {
        				System.out.println(product);
        			}
            	}
            	else
            	{
            		System.out.println("product not exist ");
            	}
            	break;
        	}
        	case 17:{
        		double sum=service.sumofProductPrice();
        		System.out.println(sum);
        		break;
        	}
        	case 18:{
        		double avg=service.avgofProductPrice();
        		System.out.println(avg);
        		break;
        	}
        	case 19:{
        		double max=service.maxofProductPrice();
        		System.out.println(max);
        		break;
        	}
        	case 20:{
        		double min= service.minofProductPrice();
        		System.out.println(min);
        		break;
        	}
		default:{
			System.out.println("invalid choice !!");
			break;
		}
			
		}
		System.out.println("do you want to continue ");
		ch=scanner.next().charAt(0);
		
	} while (ch=='y' ||ch=='Y');
}
}
