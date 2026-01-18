package e_commerce.api.e_commerce.controller;

import e_commerce.api.e_commerce.model.Product;
import e_commerce.api.e_commerce.model.Review;
import e_commerce.api.e_commerce.service.ProductService;
import e_commerce.api.e_commerce.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @Autowired
    ProductService productService;
    @GetMapping("/review/{rId}")
    public Review getReview(@PathVariable Long rId){
        return reviewService.getReviewById(rId);
    }

    @DeleteMapping("/removeReview/{rId}")
    public ResponseEntity removeReviewById(@PathVariable Long rId){
        reviewService.removeReview(rId);
        return ResponseEntity.accepted().build();
    }

    public Review makeReviewObj(Map<String, Object> payload){
        int rating = (Integer) payload.get("rating");
        String reviewText = (String) payload.get("reviewText");
        Long pId = Long.valueOf(payload.get("productId").toString());

        Product product = productService.findProductById(pId)
                .orElseThrow(()-> new RuntimeException("Can't find product"));
        Review review = new Review();
        review.setRating(rating);
        review.setReviewText(reviewText);
        review.setProduct(product);
        return review;
    }
    @PostMapping("/addReview")
    public Review addReview(@RequestBody Map<String, Object> payload){
        Review review = makeReviewObj(payload);
        return reviewService.addReview(review);
    }

    @PostMapping("/updateReview")
    public Review updateReview(@RequestBody Map<String, Object> payload){
        Review review = makeReviewObj(payload);
        return reviewService.updateReview(review);
    }
}
