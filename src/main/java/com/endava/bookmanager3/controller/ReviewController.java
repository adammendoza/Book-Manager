package com.endava.bookmanager3.controller;

import com.endava.bookmanager3.model.Review;
import com.endava.bookmanager3.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {

        this.reviewService = reviewService;
    }


    @GetMapping
    public List<Review> getReviews() {

        return reviewService.getReviews();
    }


    @GetMapping("/{reviewId}")
    public Review getReview(@PathVariable Long reviewId) {

        return reviewService.getReviewById(reviewId);
    }


    @PostMapping
    public Review createReview(@Valid @RequestBody Review review) {

        return reviewService.addReview(review);
    }

    @PutMapping("/{reviewId}")
    public Review updateReview(@PathVariable Long reviewId, @Valid @RequestBody Review reviewDetails) {

        return reviewService.updateReview(reviewId, reviewDetails);
    }


    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReviewById(reviewId);
        return ResponseEntity.ok().build();
    }
}
