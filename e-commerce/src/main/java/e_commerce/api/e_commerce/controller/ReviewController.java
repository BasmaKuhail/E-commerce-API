package e_commerce.api.e_commerce.controller;

import e_commerce.api.e_commerce.model.Review;
import e_commerce.api.e_commerce.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @GetMapping("/review/{rId}")
    public Review getReview(@PathVariable Long rId){
        return reviewService.getReviewById(rId);
    }
}
