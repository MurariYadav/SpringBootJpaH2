package org.sathyatech.raghu.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.sathyatech.raghu.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long>{

	//Query Methods Test
	
	//findBy methods
	Optional<Product> findByProdCode(String prodCode);
	List<Product> findByProdCodeContainingIgnoreCase(String prodCode);
	@Query("select p from #{#entityName} p where p.prodCost<:cost")
	//@Query("select p from Product p where p.prodCost>?1")
	//@Query("select p from Product p where p.prodCost>?1")
	List<Product> getProductBasedOnCost(@Param("cost")  double cost);
	
	@Modifying
	@Transactional
	@Query("update Product p set p.prodCode=:prodCode where p.prodId=:prodId")
	int updateProdCodeByProdId(@Param("prodCode")String prodCode,@Param("prodId")Long prodId);
	@Transactional
	int deleteByProdCodeLike(String prodCode);
	
	
	
	//Projections Test
	List<ProductOne> findByProdCostGreaterThan(Double prodCost);
	<T> List<T> findByProdCostGreaterThan(Double prodCost,Class<T> clz);
	
	//Projection Type#1
	interface ProductOne{
		String getProdCode();
		Double getProdCost();
	}
	
	//Projection Type#2
	interface ProductTwo{
		@Value("#{target.prodCode +'=>cost is=>'+ target.prodCost}")
		String getProdCode();
		Date getDateOfMfg();
	}
	
	
}