package com.example.listingfunctionalarea;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ListingController {

	@GetMapping("/activeListings")
	public String displayActiveListings(Model model) {
		return "activeListings";
	}
}
