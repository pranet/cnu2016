package com.cnu2016.nagarwal.repository;

import com.cnu2016.nagarwal.model.Orders;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by niteshagarwal002 on 09/07/16.
 */
@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderRepository extends PagingAndSortingRepository<Orders, Integer> {

}
