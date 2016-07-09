package com.cnu2016.nagarwal.repository;

import com.cnu2016.nagarwal.model.Orders;
import com.cnu2016.nagarwal.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by niteshagarwal002 on 09/07/16.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
    public User findUniqueByUserName(String userName);
}