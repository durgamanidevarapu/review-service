package com.product.review.reviewservice.dao;

import com.product.review.reviewservice.domain.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface  ReviewServiceDao extends CrudRepository<Review, Long> {

    @Query("select r from Review r where r.productId=:productId")
    List<Review> findByProductId(@Param("productId") int productId);

}
