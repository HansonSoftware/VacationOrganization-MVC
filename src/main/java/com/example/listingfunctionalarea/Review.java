package com.example.listingfunctionalarea;

import java.util.Date;
import java.util.ArrayList;

public class Review{

    private Long id;

    private Long reviewId;

	private long userID;
    private Date lastEdit;


    private ArrayList<ReviewComment> comments;
    private int rating;

	public Review(long userID, Date lastEdit, ArrayList<ReviewComment> comments, int rating, long reviewId) {
        this.userID = userID;
        this.lastEdit = lastEdit;
        this.comments = comments;
        this.rating = rating;
        this.reviewId = reviewId;
	}

    public Long getId(){
        return this.id;
    }

    public Long getReviewId(){
        return this.reviewId;
    }

    public void setReviewId(long reviewId){
        this.reviewId = reviewId;
    }

    public long getUserID(){
        return this.userID;
    }

    public void setUserID(long userID){
        this.userID = userID;
    }

    public void setRating(int rating){
        this.rating = rating;
    }
	
    public int getRating(){
        return this.rating;
    }

    public void setComments(ArrayList<ReviewComment> comments){
        this.comments = comments;
    }

    public ArrayList<ReviewComment> getComments(){
        return this.comments;
    }

    public Date getLastEdit(){
        return this.lastEdit;
    }

    public void setLastEdit(Date lastEdit){
        this.lastEdit = lastEdit;
    }

    public void editReview(ReviewComment comment, int rating){
        this.comments.add(0, comment);
        this.rating = rating;
        this.lastEdit = comment.getDate();
    }

}
