package com.endava.bookmanager3.controller;

import com.endava.bookmanager3.exception.ResourceNotFoundException;
import com.endava.bookmanager3.model.Review;
import com.endava.bookmanager3.service.ReviewService;
import com.endava.bookmanager3.util.AttributeNames;
import com.endava.bookmanager3.util.MappingNames;
import com.endava.bookmanager3.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {

        this.reviewService = reviewService;
    }


    @GetMapping(MappingNames.REVIEWS)
    public String getReviews(Model model) {

        List<Review> reviews = reviewService.getReviews();
        model.addAttribute(AttributeNames.REVIEWS, reviews);
        return ViewNames.REVIEWS;
    }


    @GetMapping(MappingNames.VIEW_REVIEW)
    public String getReview(@RequestParam Long id, Model model) {

        Review review = reviewService.getReviewById(id);

        if (review == null) {
            throw new ResourceNotFoundException("Review", "id", id);
        }

        model.addAttribute(AttributeNames.REVIEW, review);
        return ViewNames.VIEW_REVIEW;
    }


    @GetMapping(MappingNames.ADD_REVIEW)
    public String addEditReview(@RequestParam(required = false, defaultValue = "-1") Long id, Model model) {

        Review review = reviewService.getReviewById(id);

        if (review == null) {
            review = new Review();
        }

        model.addAttribute(AttributeNames.REVIEW, review);
        return ViewNames.ADD_REVIEW;
    }


    @PostMapping(MappingNames.ADD_REVIEW)
    public String processReview(@Valid @ModelAttribute(AttributeNames.REVIEW) Review review) {

        if (review.getId() == null) {
            reviewService.addReview(review);
        } else {
            reviewService.updateReview(review);
        }

        return "redirect:/" + MappingNames.REVIEWS;
    }


    @GetMapping(MappingNames.DELETE_REVIEW)
    public String deleteReview(@RequestParam Long id) {
        reviewService.deleteReviewById(id);
        return "redirect:/" + MappingNames.REVIEWS;
    }
}
