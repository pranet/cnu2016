package com.cnu2016.nagarwal.repository;

import com.cnu2016.nagarwal.model.Feedback;
import com.cnu2016.nagarwal.model.Orders;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by niteshagarwal002 on 09/07/16.
 */
public interface FeedbackRespository extends PagingAndSortingRepository<Feedback, Integer> {

}