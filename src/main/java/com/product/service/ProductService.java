package com.product.service;

import java.util.List;

import com.product.dao.ProductDao;
import com.product.entity.Product;

public class ProductService {
	private ProductDao dao=new ProductDao();
	public String savepProduct(Product product) {
		return dao.savepProduct(product);
}
	public Product getProductById(int ProductId) {
		return dao.getProductById(ProductId);
		
	}
	
	public String deleteProductById(int productId) {
		return dao.deleteProductById(productId);
	}
	
	
	public String updateproduct(Product product) {
		// TODO Auto-generated method stub
		return dao.updateproduct(product);
	}
	public List<Product> getAllProducts() {
	
		return dao.getAllProducts();
	}
	
	public List<Product> getAllProductAscendingOrder() {
		
		return dao.getAllProductAscendingOrder();
	}
	
  public List<Product> getAllProductDescendingOrder() {
		
		return dao.getAllProductDescendingOrder();
	}
   public List<Product> getPaginationData() {
	
	return dao.getPaginationData();
}
   public List<Product> RestrictionExample() {
		
		return dao.RestrictionExample();
	}
   public List<Product> RestrictionExBetween() {
		
		return dao.RestrictionExBetween();
	}
   public List<Product> RestrictionExLessthan() {
		
		return dao.RestrictionExLessthan();
	}
   public List<Product> RestrictionExGreaterthan() {
		
		return dao.RestrictionEXGreaterthan();
	}
   public List<Product> RestrictionExGreaterthanEqual() {
		
		return dao.RestrictionEXGreaterthanEqual();
	}
public List<Product> RestrictionExAllEqual() {
	
	return dao.RestrictionExAllEqual();
}
public List<Product> RestrictionExInMethod() {
	
	return dao.RestrictionExInMethod();
}
public List<Product> RestrictionExLike() {
	
	return dao.RestrictionExLike();
}
public double sumofProductPrice() {
	return dao.sumofProductPrice();
}
public double avgofProductPrice() {
	return dao.avgofProductPrice();
}
public double maxofProductPrice() {
	return dao.maxofProductPrice();
}
public double minofProductPrice() {
	
	return dao.minofProductPrice();
}
}