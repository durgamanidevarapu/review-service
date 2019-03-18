package com.product.review.reviewservice.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    private String description;
    private String rating;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Column(name = "product_id")
    private int productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                ", productId=" + productId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return productId == review.productId &&
                id.equals(review.id) &&
                Objects.equals(description, review.description) &&
                Objects.equals(rating, review.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, rating, productId);
    }
}
