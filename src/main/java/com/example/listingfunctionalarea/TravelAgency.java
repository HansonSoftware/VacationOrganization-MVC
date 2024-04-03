package com.example.listingfunctionalarea;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TravelAgency {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private int agencyID;
    private String name;
    private ArrayList<Listing> listings;

    public TravelAgency(int agencyID, String name, ArrayList<Listing> listings) {
        this.agencyID = agencyID;
        this.name = name;
        this.listings = listings;
    }

    public int getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(int agencyID) {
        this.agencyID = agencyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Listing> getListings() {
        return listings;
    }

    public void setListings(ArrayList<Listing> listings) {
        this.listings = listings;
    }

    // Method to get all listings
    public List<Listing> getAllListings() {
        return listings;
    }

    // Method to get active listings
    public List<Listing> getActiveListings() {
        List<Listing> activeListings = new ArrayList<>();
        for (Listing listing : listings) {
            if (listing.getVacancy()) {
                activeListings.add(listing);
            }
        }
        return activeListings;
    }

    public void addListing(Listing listing) {
        listings.add(listing);
    }

    public void updateListing(Listing updatedListing) {
        for (int i = 0; i < listings.size(); i++) {
            if (listings.get(i).getPropertyID() == updatedListing.getPropertyID()) {
                listings.set(i, updatedListing);
                break;
            }
        }
    }

    public void deleteListing(int propertyID) {
        for (int i = 0; i < listings.size(); i++) {
            if (listings.get(i).getPropertyID() == propertyID) {
                listings.remove(i);
                break;
            }
        }
    }
}
