package com.product.review.reviewservice.dao;

import com.product.review.reviewservice.domain.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ReviewServiceDao extends CrudRepository<Review, Long> {


    List<Review> findByProductId(@Param("productId") int productId);

}
