package e_commerce.api.e_commerce.service;

import e_commerce.api.e_commerce.model.Review;
import e_commerce.api.e_commerce.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review getReviewById (Long id){
        return reviewRepository.getReferenceById(id);
    }
}
