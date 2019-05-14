package com.endava.bookmanager3.service;

import com.endava.bookmanager3.exception.ResourceNotFoundException;
import com.endava.bookmanager3.model.Review;
import com.endava.bookmanager3.repository.IReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final IReviewRepository reviewRepository;

    @Autowired
    public ReviewService(IReviewRepository reviewRepository) {

        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviews() {

        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {

        return reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Review", "id", id));
    }

    public Review addReview(Review reviewToAdd) {

        return reviewRepository.save(reviewToAdd);
    }

    public Review updateReview(Long id, Review modifiedReview) {

        Review reviewToUpdate = reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Review", "id", id));
        reviewToUpdate.setDescription(modifiedReview.getDescription());
        reviewToUpdate.setRating((modifiedReview.getRating()));
        reviewToUpdate.setBook(modifiedReview.getBook());
        reviewToUpdate.setUser(modifiedReview.getUser());
        return reviewRepository.save(reviewToUpdate);
    }

    public void deleteReviewById(Long id) {

        Review reviewToDelete = reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Review", "id", id));
        reviewRepository.delete(reviewToDelete);
    }
}
