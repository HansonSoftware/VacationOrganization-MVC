package com.example.listingfunctionalarea;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListingController {

	// VIEW for Active Listings
	@GetMapping("/activeListings")
	public String displayActiveListings(Model model) {

		List<Listing> listings = new ArrayList<>();

		Listing listing1 = new Listing(1, "Beautiful House", 150, "house.jpeg", "New York", true, new ArrayList<>());
		Listing listing2 = new Listing(2, "Cozy Apartment", 100, "apartment.jpeg", "San Francisco", true,
				new ArrayList<>());
		Listing listing3 = new Listing(3, "Spacious Villa", 300, "villa.jpeg", "Los Angeles", true, new ArrayList<>());
		Listing listing4 = new Listing(4, "Brand New House", 200, "house2.jpeg", "Virginia Beach", true, new ArrayList<>());
		Listing listing5 = new Listing(5, "New Apartment", 120, "apartment2.jpeg", "Las Vegas", true, new ArrayList<>());
		Listing listing6 = new Listing(6, "Stunning Villa", 400, "villa2.jpeg", "Canada", true, new ArrayList<>());

		listings.add(listing1);
		listings.add(listing2);
		listings.add(listing3);
		listings.add(listing4);
		listings.add(listing5);
		listings.add(listing6);

		model.addAttribute("listings", listings);
		model.addAttribute("username", "Timmy27");

		return "activeListings";
	}

	// VIEW for Listing
	@GetMapping("/listing/{propertyID}")
	public String displayListing(Model model) {

		ArrayList<Review> reviews = new ArrayList<>();

		// Call Einins API

		reviews.add(new Review("Hayden", "Splendid indeed!", new Date(), 4, 1));
		reviews.add(new Review("Einin", "It was great :)", new Date(), 5, 2));
		reviews.add(new Review("Tom", "It was just ok, not too great, not bad.", new Date(), 3, 3));

		Listing listing = new Listing(
				1,
				"Beautiful House",
				150,
				"house.jpeg",
				"New York",
				true,
				reviews);

		model.addAttribute("listing", listing);
		model.addAttribute("username", "hayden123");

		return "listing";
	}
}
