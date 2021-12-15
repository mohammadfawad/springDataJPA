package com.springboot.springDataJPA.Repository;

import org.springframework.data.repository.CrudRepository;
import com.springboot.springDataJPA.Entity.Product;
import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	//Custom Finder Methods 
	List<Product> findByProductId(Integer productId);	
	List<Product> findByProductName(String productName);
	List<Product> findByProductDescription(String productDescription);
	List<Product> findByProductPrice(BigDecimal productPrice);
	List<Product> findByProductNameAndProductPrice(String productName, BigDecimal productPrice);
}
