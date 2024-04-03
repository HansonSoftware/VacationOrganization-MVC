package com.example.listingfunctionalarea;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface TravelAgencyRepository extends 
	    CrudRepository<TravelAgency, Long> {

			List<ReviewingUser> findByUserID(Long userID);

			Optional<ReviewingUser> findById(Long id);
		}
