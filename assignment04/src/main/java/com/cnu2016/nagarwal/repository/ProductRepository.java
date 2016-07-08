package com.cnu2016.nagarwal.repository;

/**
 * Created by niteshagarwal002 on 07/07/16.
 */
import java.util.List;

import com.cnu2016.nagarwal.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

//    List<Product> findByProductName(@Param("productName") String productName);
//    public Product findByIdProduct

}
