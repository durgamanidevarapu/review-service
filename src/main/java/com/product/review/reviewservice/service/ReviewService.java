package com.product.review.reviewservice.service;

import com.product.review.reviewservice.domain.Review;

import java.util.Optional;

public interface ReviewService {

    public Review addProdcutReview(Review review);
    public Iterable<Review>  findProductReviews(Long product_id);
    public Review updateproductReview(Review review);
    public Optional<Review> findProductReview(Long id) ;

}
