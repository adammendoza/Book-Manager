package com.endava.bookmanager3.service;

import com.endava.bookmanager3.exception.AppException;
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

        return reviewRepository.findById(id).orElse(null);
    }

    public void addReview(Review reviewToAdd) {

        reviewRepository.save(reviewToAdd);
    }

    public void updateReview(Review modifiedReview) {

        Review reviewToUpdate = reviewRepository.findById(modifiedReview.getId()).orElse(null);

        if (reviewToUpdate == null) {
            throw new AppException("Review to update not found!");
        }

        reviewToUpdate.setDescription(modifiedReview.getDescription());
        reviewToUpdate.setRating((modifiedReview.getRating()));
        reviewToUpdate.setBook(modifiedReview.getBook());
        reviewToUpdate.setUser(modifiedReview.getUser());
        reviewRepository.save(reviewToUpdate);
    }

    public void deleteReviewById(Long id) {

        Review reviewToDelete = reviewRepository.findById(id).orElse(null);

        if (reviewToDelete == null)
            throw new AppException("Review to delete not found!");

        reviewRepository.delete(reviewToDelete);
    }
}
