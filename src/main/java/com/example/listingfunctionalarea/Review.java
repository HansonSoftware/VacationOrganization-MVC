package com.example.listingfunctionalarea;

import java.util.Date;

public class Review {

    private Long id;

    private Long reviewId;
    private String userName;
    private String comment;
    private Date lastEdit;
    private int rating;

    public Review(String userName, String comment, Date lastEdit, int rating, long reviewId) {
        this.userName = userName;
        this.comment = comment;
        this.lastEdit = lastEdit;
        this.rating = rating;
        this.reviewId = reviewId;
    }

    public Long getId() {
        return this.id;
    }

    public Long getReviewId() {
        return this.reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return this.comment;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return this.rating;
    }

    public Date getLastEdit() {
        return this.lastEdit;
    }

    public void setLastEdit(Date lastEdit) {
        this.lastEdit = lastEdit;
    }
}
