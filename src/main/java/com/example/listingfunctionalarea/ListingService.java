package com.example.listingfunctionalarea;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service("reviewService")
public class ListingService {
    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    ReviewingUserRepository reviewingUserRepository;

    @Autowired
    ReviewCommentRepository reviewCommentRepository;

    @Autowired
    PropertyUnderReviewRepository propertyUnderReviewRepository;
    
    //Save
    public void saveReview (Review review){
        reviewRepository.save(review);
    }

    public void saveReviewingUser (ReviewingUser reviewingUser){
        reviewingUserRepository.save(reviewingUser);
    }

    public void saveReviewComment (ReviewComment reviewComment){
        reviewCommentRepository.save(reviewComment);
    }

    public void savePropertyUnderReview(PropertyUnderReview propertyUnderReview){
        propertyUnderReviewRepository.save(propertyUnderReview);
    }
}
