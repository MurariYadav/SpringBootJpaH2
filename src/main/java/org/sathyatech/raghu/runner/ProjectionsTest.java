package org.sathyatech.raghu.runner;

import java.util.Date;

import org.sathyatech.raghu.model.Product;
import org.sathyatech.raghu.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

@Component
public class ProjectionsTest implements CommandLineRunner{

	@Autowired
	private ProductRepository repo;
	
	public void basicData() {
		repo.save(new Product("RED MI 5", 600.66, new Date(), true));
		repo.save(new Product("REAL PRO 2", 800.66, new Date(), true));
		repo.save(new Product("SAMSUNG PLX-6", 500.66, new Date(), false));
		repo.save(new Product("MICRO MAX", 900.66, new Date(), true));

	}
	@Override
	public void run(String... args) throws Exception {
		basicData();
		System.out.println("----");
		//repo.findByProdCostGreaterThan(500.0).forEach((e)-> System.out.println(e.getProdCode()+","+e.getProdCost()));
		
		
		repo.findByProdCostGreaterThan(800.0, ProductRepository.ProductTwo.class)
		.forEach((e)-> System.out.println(e.getProdCode()+","+e.getDateOfMfg()));
		
		Product p=new Product();
		p.setProdCost(900.66);
		
		System.out.println("---------------------");
		repo.findAll(Example.of(p)).forEach(System.out::println);
		
		
		
		
	}
}
