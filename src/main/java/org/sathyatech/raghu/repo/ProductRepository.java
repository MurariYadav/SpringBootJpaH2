package org.sathyatech.raghu.repo;

import org.sathyatech.raghu.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
