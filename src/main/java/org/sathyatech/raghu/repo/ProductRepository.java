package org.sathyatech.raghu.repo;

import java.util.List;
import java.util.Optional;

import org.sathyatech.raghu.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long>{

	//findBy methods
	Optional<Product> findByProdCode(String prodCode);
	List<Product> findByProdCodeContainingIgnoreCase(String prodCode);
	@Query("select p from #{#entityName} p where p.prodCost<:cost")
	//@Query("select p from Product p where p.prodCost>?1")
	//@Query("select p from Product p where p.prodCost>?1")
	List<Product> getProductBasedOnCost(@Param("cost")  double cost);
	
	@Modifying
	@Query("update Product p set p.prodCode=:prodCode where p.prodId=:prodId")
	int updateProdCodeByProdId(@Param("prodCode")String prodCode,@Param("prodId")Long prodId);
	
	int deleteByProdCodeLike(String prodCode);
}