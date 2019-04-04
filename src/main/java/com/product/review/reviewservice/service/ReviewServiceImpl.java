package com.product.review.reviewservice.service;

import com.product.review.reviewservice.dao.ReviewServiceDao;
import com.product.review.reviewservice.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewServiceDao reviewServiceDao;

    @Override
    public Review addProdcutReview(Review review) {
        return reviewServiceDao.save(review);
    }

    @Override
    public Iterable<Review> findProductReviews(int productId) {

        return reviewServiceDao.findByProductId(productId);
    }

    @Override
    public Review updateproductReview(Review review) {

        return reviewServiceDao.save(review);
    }

    @Override
    public Optional<Review> findProductReview(Long id) {
        return reviewServiceDao.findById(id);

    }
}
