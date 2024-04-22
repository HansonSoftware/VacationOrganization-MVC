package com.example.listingfunctionalarea;

import java.util.ArrayList;

public class Listing {

    private int propertyID;
    private String name;
    private int cost;
    private String imageURL;
    private Location location;
    private Boolean vacancy;
    private ArrayList<Review> reviews;

    public Listing(int propertyID, String name, int cost, String imageURL, Location location, Boolean vacancy,
            ArrayList<Review> reviews) {
        this.propertyID = propertyID;
        this.name = name;
        this.cost = cost;
        this.imageURL = imageURL;
        this.location = location;
        this.vacancy = vacancy;
        this.reviews = reviews;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Boolean getVacancy() {
        return vacancy;
    }

    public void setVacancy(Boolean vacancy) {
        this.vacancy = vacancy;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }
}
