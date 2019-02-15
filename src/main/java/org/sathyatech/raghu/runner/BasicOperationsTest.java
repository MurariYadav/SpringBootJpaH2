package org.sathyatech.raghu.runner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.sathyatech.raghu.model.Product;
import org.sathyatech.raghu.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

@Component
public class BasicOperationsTest implements CommandLineRunner{
	@Autowired
	private ProductRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		//save data
		repo.save(new Product("RED MI 5", 600.66, new Date(), true));
		repo.save(new Product("REAL PRO 2", 800.66, new Date(), true));
		repo.save(new Product("SAMSUNG PLX-6", 500.66, new Date(), false));
		repo.save(new Product("MICRO MAX", 900.66, new Date(), true));
		
		//fetch all records
		repo.findAll().forEach(System.out::println);
		
		//find specific
		List<Long> list=Arrays.asList(3L,4L);
		repo.findAllById(list).forEach(System.out::println);
		
		//find one
		Optional<Product> prod=repo.findById(22L);
		System.out.println(prod.isPresent()?prod.get():"No Data Found");
		
		//sort by
		repo.findAll(Sort.by("prodCode")).forEach(System.out::println);;
		repo.findAll(Sort.by(Direction.DESC, "prodCode")).forEach(System.out::println);;
		
		//count no.of rows
		System.out.println("Cuurent Rows in Table:"+repo.count());
		
		//delete row based on ID
		repo.deleteById(2L);
		
		//is record exist
		System.out.println(repo.existsById(3L)?"Yes data is available":"Seems No Data Found");
		
		
		
		
	}
}
