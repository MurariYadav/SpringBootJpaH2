package org.sathyatech.raghu.runner;

import java.util.Date;
import java.util.Optional;

import org.sathyatech.raghu.model.Product;
import org.sathyatech.raghu.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Order(1)
public class FindMethodsTest implements CommandLineRunner{

	@Autowired
	private ProductRepository repo;

	public void basicData() {
		repo.save(new Product("RED MI 5", 600.66, new Date(), true));
		repo.save(new Product("REAL PRO 2", 800.66, new Date(), true));
		repo.save(new Product("SAMSUNG PLX-6", 500.66, new Date(), false));
		repo.save(new Product("MICRO MAX", 900.66, new Date(), true));

	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		//setup basic data
		basicData();


		System.out.println(repo.findById(1L).get());
		//Test methods
		Optional<Product> prod=repo.findByProdCode("MICRO MAX");

		if(prod.isPresent())
			System.out.println(prod.get());
		else
			System.out.println("not found");

		repo.findByProdCodeContainingIgnoreCase("r").forEach(System.out::println);
		repo.getProductBasedOnCost(1600.0).forEach(System.out::println);


		//non select operations test
		int count=0; 
		count=repo.updateProdCodeByProdId("AAA", 1L);
		System.out.println("count:"+count);
		count=repo.deleteByProdCodeLike("R%");
		System.out.println("count:"+count);
	}
}
