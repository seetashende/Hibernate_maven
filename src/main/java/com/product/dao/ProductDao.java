package com.product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.product.config.HibernateUtility;
import com.product.entity.Product;


public class ProductDao {
	private SessionFactory sessionFactory;
	
public ProductDao() {
	sessionFactory = HibernateUtility.getsessionFactory();
	}

public String savepProduct(Product product) {
	Session session=null;
	boolean isAdded= false;
	try {
		 session =sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Product dbproduct= session.get(Product.class, product.getProductId());
		if(dbproduct==null) {
		session.save(product);
		tr.commit();
		isAdded=true;
		}

		
	} catch (Exception e) {
		e.printStackTrace();
	} 
	finally {
		if (session!=null){
			session.close();
		}
	}
	if(isAdded) {
		return "saved !!!";
	}
	else
	{
		return "Already Exist !!";
	}
	
}

public Product getProductById(int productId) {
	Session session=null;
	Product product=null;
	try {
	session=sessionFactory.openSession();
product = session.get(Product.class, productId);
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		if (session!=null){
			session.close();
	}
	return product;
}
}


public String deleteProductById(int productId) {
	Session session =null;
    String msg=null;
	try {
	 session = sessionFactory.openSession();
		Transaction trasaction= session .beginTransaction();
		Product product =session .get(Product.class, productId);
		if(product!=null) {
		session.delete(product);
		trasaction.commit();
		msg="deleted";
		}
		else {
			System.out.println("product not exist with Id ="+product);
		}
	}
catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		if (session!=null){
			session.close();
	}
	return msg;
	
}
}


public String updateproduct(Product product) {
	// TODO Auto-generated method stub
Session session=null;
	boolean isupdated=false;
	try {
		session = sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Product dbproduct = session.get(Product.class, product.getProductId());
		if(dbproduct!=null) {
		session.update(product);
		tr.commit();
		isupdated=true;
		}
	
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (session!=null){
			session.close();
	}
		if(isupdated) {
			return "product updated";
		}else {
	return "product not exists";
		}
}
}
public List<Product> getAllProducts(){
	Session session=null;
	List<Product> list =null;
	try {
		session= sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Product.class);
		list=criteria.list();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (session!=null){
			session.close();
	}
	return list;
}
}
public List<Product> getAllProductAscendingOrder(){
	Session session=null;
	List<Product> list =null;
	try {
		session= sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Product.class);
		criteria.addOrder(Order.asc("productPrice"));
		list=criteria.list();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (session!=null){
			session.close();
	}
	return list;
}
}
public List<Product> getAllProductDescendingOrder(){
	Session session=null;
	List<Product> list =null;
	try {
		session= sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Product.class);
		criteria.addOrder(Order.desc("productPrice"));
		list=criteria.list();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (session!=null){
			session.close();
	}
	return list;
}
}

public List<Product> getPaginationData() {
	
	Session session=null;
	List<Product> list =null;
	try {
		session= sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Product.class);
		criteria.setFirstResult(1);
		criteria.setMaxResults(4);
		list=criteria.list();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (session!=null){
			session.close();
	}
	return list;
}
}

public List<Product> RestrictionExample() {

	Session session=null;
	List<Product> list =null;
	try {
		session= sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Product.class);
	 Criterion	ctr=Restrictions.eq("productName", "pencil");
	     criteria.add(ctr);
		list=criteria.list();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (session!=null){
			session.close();
	}
	return list;
}
}

public List<Product> RestrictionExBetween() {
	Session session=null;
	List<Product> list =null;
	try {
		session= sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Product.class);
	 Criterion ctr=Restrictions.between("productId", 101, 104);
	     criteria.add(ctr);
		list=criteria.list();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (session!=null){
			session.close();
	}
	return list;
}
}

public List<Product> RestrictionExLessthan() {
	Session session=null;
	List<Product> list =null;
	try {
		session= sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Product.class);
	Criterion ctr=Restrictions.le("productId", 103);
	// Criterion ctr=Restrictions.le("productPrice", 500);
	     criteria.add(ctr);
		list=criteria.list();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (session!=null){
			session.close();
	}
	return list;
}
}

public List<Product> RestrictionEXGreaterthan() {
	Session session=null;
	List<Product> list =null;
	try {
		session= sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Product.class);
	//Criterion ctr=Restrictions.gt("productId", 102);
	Criterion ctr=Restrictions.gt("productPrice", 500d);

	     criteria.add(ctr);
		list=criteria.list();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (session!=null){
			session.close();
	}
	return list;
}
}
public List<Product> RestrictionEXGreaterthanEqual() {
	Session session=null;
	List<Product> list =null;
	try {
		session= sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Product.class);
	//Criterion ctr=Restrictions.gt("productId", 102);
	Criterion ctr=Restrictions.ge("productId", 105);

	     criteria.add(ctr);
		list=criteria.list();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (session!=null){
			session.close();
	}
	return list;
}
}

public List<Product> RestrictionExAllEqual() {
	Session session=null;
	List<Product> list =null;
	try {
		session= sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Product.class);
	//Map<String, Object> map = new HashMap<>();
	//map.put("productName", "pen");
	//map.put("productPrice", 10d);
	//Criterion ctr= Restrictions.allEq(map);
	//criteria.add(ctr);
	//System.out.println("***************************************");
	//Criterion name=Restrictions.eq("productName", "pen");
	//Criterion price=Restrictions.eq("productPrice", 20d);
	//criteria.add(Restrictions.and(name,price));
	//System.out.println("***************************************");
	Criterion name=Restrictions.eq("productName", "pen");
	Criterion price=Restrictions.eq("productPrice", 10d);
	criteria.add(Restrictions.or(name,price));
		list=criteria.list();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (session!=null){
			session.close();
	}
	return list;
}
}

public List<Product> RestrictionExInMethod() {
	Session session=null;
	List<Product> list =null;
	try {
		session= sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Product.class);
	criteria.add(Restrictions.in("productPrice",10d, 20d,500d));
	     
		list=criteria.list();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (session!=null){
			session.close();
	}
	return list;
}
}

public List<Product> RestrictionExLike() {
	Session session=null;
	List<Product> list =null;
	try {
		session= sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Product.class);
	criteria.add(Restrictions.like("productName", "%e%"));
	     
		list=criteria.list();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (session!=null){
			session.close();
	}
	return list;
}
}

public double sumofProductPrice() {
	
	Session session=null;
	double sum=0;
	try {
		session=sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Product.class);
		criteria.setProjection(Projections.sum("productPrice"));
		List<Double> list= criteria.list();
		sum=list.get(0);
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (session!=null){
			session.close();
	}	
	return sum;
}
}
public double avgofProductPrice() {
	
	Session session=null;
	double avg=0;
	try {
		session=sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Product.class);
		criteria.setProjection(Projections.avg("productPrice"));
		List<Double> list= criteria.list();
		avg=list.get(0);
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if (session!=null){
			session.close();
	}	
	return avg;
}
}
public double maxofProductPrice() {
	
	Session session=null;
	double max=0;
	try {
		session=sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Product.class);
		criteria.setProjection(Projections.max("productPrice"));
		List<Double> list= criteria.list();
		max=list.get(0);
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		if (session!=null){
			session.close();
	}	
	return max;
}
}

public double minofProductPrice() {
	Session session=null;
	double min=0;
	try {
		session=sessionFactory.openSession();
		Criteria criteria= session.createCriteria(Product.class);
		criteria.setProjection(Projections.min("productPrice"));
		List<Double> list= criteria.list();
		min=list.get(0);
	} catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		if (session!=null){
			session.close();
	}	
	return min;

	}
}
}