package com.product.review.reviewservice.dao;

import com.product.review.reviewservice.domain.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ReviewServiceDao extends CrudRepository<Review, Long> {

}
