package com.product.review.reviewservice;


import com.product.review.reviewservice.domain.Review;
import com.product.review.reviewservice.domain.ReviewDto;
import com.product.review.reviewservice.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class ReviewServiceController {

    @Autowired
    ReviewService reviewService;
    Logger log = LoggerFactory.getLogger(ReviewServiceController.class);
    ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/products/{productId}/reviews")
    public ResponseEntity<Object> addReview(@RequestBody ReviewDto reviewDto, @PathVariable int productId){
        Review review = convertToEntity(reviewDto);
        review.setProductId(productId);
        Review savedReview  = reviewService.addProdcutReview(review);
        log.info("adding reviews to product");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedReview.getId()).toUri();

        return ResponseEntity.created(location).build();


    }

    @GetMapping("/{productId}/reviews")
    public List<Review> getProductReview(@PathVariable int productId){
        Iterable<Review> reviews = reviewService.findProductReviews(productId);
        List<Review> reviewList = new ArrayList<>();
        reviews.forEach(reviewList::add);

        return  reviewList;
    }

    @PutMapping("/{productId}/reviews/{reviewId}")
    public ResponseEntity<Object> updateProductReview(@RequestBody ReviewDto reviewDto, @PathVariable int productId, @PathVariable Long reviewId)
    {
        Optional<Review> optionalReview = reviewService.findProductReview(reviewId);
        if(!optionalReview.isPresent())
            return ResponseEntity.noContent().build();
        Review review = updateReviewEntity(reviewDto,optionalReview.get());
        review.setProductId(productId);
        Review updatedReview = reviewService.addProdcutReview(review);
        log.info("updated review detials:{}",review.toString());
        return ResponseEntity.noContent().build();
    }

    private Review updateReviewEntity(ReviewDto reviewDto,Review review){

        Review reviewEntity = convertToEntity(reviewDto);
        reviewEntity.setId(review.getId());
        if(StringUtils.isEmpty(reviewEntity.getDescription())){
            reviewEntity.setDescription(review.getDescription());
        }
        if(StringUtils.isEmpty(review.getRating())){
            reviewEntity.setRating(review.getDescription());
        }
        return reviewEntity;
    }

private Review convertToEntity(ReviewDto reviewDto){
          return modelMapper.map(reviewDto,Review.class);
}

}
