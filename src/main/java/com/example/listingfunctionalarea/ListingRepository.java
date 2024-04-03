package com.example.listingfunctionalarea;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface PropertyUnderReviewRepository extends 
	    CrudRepository<Listing, Long> {

			List<Listing> findByPropertyID(int propertyID);

			Optional<PropertyUnderReview> findById(Long id);
		}
