package com.example.listingfunctionalarea;

import java.util.*;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.net.URL;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListingController {

	// VIEW for Active Listings
	@GetMapping("/activeListings")
	public String displayActiveListings(Model model) {

		TravelAgency agency = getActiveListingsDB();

		model.addAttribute("listings", agency.getActiveListings());
		model.addAttribute("username", "Timmy");

		return "activeListings";
	}

	// VIEW for Listing
	@GetMapping("/listing/{propertyID}")
	public String displayListing(@PathVariable("propertyID") int propertyID, Model model) {

		TravelAgency agency = getActiveListingsDB();

		Listing chosenListing = agency.getActiveListings().get(propertyID);

		ArrayList<Review> reviews = chosenListing.getReviews();

		// API call to Reviewing functional area
		String url = "http://localhost:8082/getPropertyReviews/" + propertyID;
		callReviewingMicroservice(url, reviews);

		// Update reviews list in chosenListing Object
		chosenListing.setReviews(reviews);

		// Set model attributes
		model.addAttribute("listing", chosenListing);
		model.addAttribute("username", "Timmy");

		return "listing";
	}

	private void callReviewingMicroservice(String url, ArrayList<Review> reviews) {

		try {
			String json = IOUtils.toString(new URL(url), StandardCharsets.UTF_8);
			int ratingID = 0;

			// Parse the JSON
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(json);
			JsonNode reviewsNode = root.get("reviews");
			if (reviewsNode != null && reviewsNode.isArray()) {
				for (JsonNode reviewNode : reviewsNode) {
					String userName = reviewNode.get("userName").asText();
					String comment = reviewNode.get("comment").asText();
					String lastEdit = reviewNode.get("lastEdit").asText();
					String rating = reviewNode.get("rating").asText();

					// Parse lastEdit string to Date (example format "MM/dd")
					Date lastEditDate = parseDate(lastEdit);
					// Parse rating string to int (example format "X/Y")
					int ratingValue = parseRating(rating);

					// Create review objects for each review in JSON array
					Review review = new Review(userName, comment, lastEditDate, ratingValue, ratingID);
					reviews.add(review);

					ratingID++;
				}
			}
		} catch (IOException e) {
			System.out.println("Ensure the :8092 server is running");
		}
	}

	private Date parseDate(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	private int parseRating(String ratingStr) {
		String[] parts = ratingStr.split("/");
		if (parts.length == 2) {
			try {
				return Integer.parseInt(parts[0]);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				return 0;
			}
		} else {
			// Invalid rating format
			return 0;
		}
	}

	/*
	 * getActiveListingsDB:
	 * 
	 * This is a mock database.
	 * It works fine for this small scale web app
	 *
	 * H2 was giving me trouble with imports and versioning, this was my quick
	 * solution.
	 */
	public TravelAgency getActiveListingsDB() {

		// Mock Database of 6 Property Listings
		ArrayList<Listing> listings = new ArrayList<>();
		ArrayList<Review> reviews = new ArrayList<>();
		// Add dummy review (simulate pre-existing review before stay)
		reviews.add(new Review("Sam H.", "Great place to stay!", new Date(), 5, 2));

		Location location0 = new Location("123 Main St", "New York", "NY", "10001");
		Location location1 = new Location("456 Elm St", "San Francisco", "CA", "94101");
		Location location2 = new Location("789 Oak St", "Los Angeles", "CA", "90001");
		Location location3 = new Location("321 Pine St", "Virginia Beach", "VA", "23451");
		Location location4 = new Location("654 Maple St", "Las Vegas", "NV", "89101");
		Location location5 = new Location("987 Cedar St", "Canada", "CA", "A1A 1A1");

		Listing listing0 = new Listing(0, "Beautiful House", 150, "house.jpeg", location0, true, reviews);
		Listing listing1 = new Listing(1, "Cozy Apartment", 100, "apartment.jpeg", location1, true, reviews);
		Listing listing2 = new Listing(2, "Spacious Villa", 300, "villa.jpeg", location2, true, reviews);
		Listing listing3 = new Listing(3, "Brand New House", 200, "house2.jpeg", location3, true, reviews);
		Listing listing4 = new Listing(4, "New Apartment", 120, "apartment2.jpeg", location4, true, reviews);
		Listing listing5 = new Listing(5, "Stunning Villa", 400, "villa2.jpeg", location5, true, reviews);

		listings.add(listing0);
		listings.add(listing1);
		listings.add(listing2);
		listings.add(listing3);
		listings.add(listing4);
		listings.add(listing5);

		// Create Travel Agency
		TravelAgency agency = new TravelAgency(1, "Rent Homez Quick", listings);

		return agency;
	}
}
