package com.springboot.springDataJPA;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.springboot.springDataJPA.Entity.Product;
import com.springboot.springDataJPA.Repository.ProductRepository;

@SpringBootTest
class SpringDataJpaApplicationTests {

	@Autowired
	ApplicationContext context;

	@Test
	void crudProduct() {
		ProductRepository productRepository = (ProductRepository) context.getBean(ProductRepository.class);
		Product product = new Product();
		product.setProductId(123);
		product.setProductName("Doctor Toothpaste");
		product.setProductDescription("Floride toothpaste");
		product.setProductPrice(new BigDecimal(999.751));
		// insert operation
		productRepository.save(product);
		// update operation
		product.setProductName("Colgate Toothpaste");
		productRepository.save(product);
		// get all products
		// productRepository.findAll().forEach(p->{System.out.print(p.toString() +
		// "\n");});
		// get single product
		System.out.print("\n___________________________________________\n");

		// System.out.print(productRepository.findById(122).toString());
		System.out.print("\n****************************************\n");
		// delete product by id
		// productRepository.deleteById(115);
		// Custom finder methods
		System.out.print("\n****************************************\n");
		// find By ID
		System.out.println("\n##############findById#############\n");
		Optional<Product> findById = productRepository.findById(123);
		if (findById.isEmpty())
			System.out.println("\n@@@@@@@@@@@@@@ No Match Found :: Empty \n");
		else {
			System.out.print(findById.toString());
		}
		// find By Name
		System.out.println("\n\n##############findByProductName#############\n");
		List<Product> findByProductName = productRepository.findByProductName("MacBook Pro 2019");
		if (findByProductName.isEmpty())
			System.out.println("\n@@@@@@@@@@@@@@ No Match Found :: Empty \n");
		else {
			findByProductName.forEach(p -> {
				System.out.println(p.toString());
			});
		}

		// find by Description
		System.out.println("\n\n##############findByProductDescription#############\n");
		List<Product> findByProductDescription = productRepository.findByProductDescription("Floride toothpaste");
		if (findByProductDescription.isEmpty())
			System.out.println("\n@@@@@@@@@@@@@@ No Match Found :: Empty \n");
		else {
			findByProductDescription.forEach(p -> {
				System.out.println(p.toString());
			});
		}

		// find by Price
		System.out.println("\n\n##############findByProductPrice#############\n");
		List<Product> findByProductPrice = productRepository.findByProductPrice(new BigDecimal("999.751"));
		if (findByProductPrice.isEmpty())
			System.out.println("\n@@@@@@@@@@@@@@ No Match Found :: Empty \n");
		else {
			findByProductPrice.forEach(p -> {
				System.out.println(p.toString());
			});

		}

		// find by Name And price
		System.out.println("\n\n##############findByProductNameAndProductPrice#############\n");
		List<Product> findByProductNameAndProductPrice = productRepository
				.findByProductNameAndProductPrice("MacBook Pro 2019", new BigDecimal("1000.751"));
		if (findByProductNameAndProductPrice.isEmpty())
			System.out.println("\n@@@@@@@@@@@@@@ No Match Found :: Empty \n");
		else {
			findByProductNameAndProductPrice.forEach(p -> {
				System.out.println(p.toString());
			});
		}

		System.out.print("\n_______________________________________________\n");
		System.out.print(
				"\n JPA Repositories Documentation and Keywords :: \nhttps://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference\n");
	}

}
