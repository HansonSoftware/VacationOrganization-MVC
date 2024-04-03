package com.example.listingfunctionalarea;
import java.util.Date;

public class ReviewComment{

    private Long id;

    private String content;
    private Date date;
    private Long reviewId;

	public ReviewComment (String content, Date date, long reviewId) {
        this.content = content;
        this.date = new Date(System.currentTimeMillis());
        this.reviewId = reviewId;
	}

    public Long getId(){
        return this.id;
    }

    public void setReviewId(long reviewId){
        this.reviewId = reviewId;
    }

    public long getReviewId(){
        return this.reviewId;
    }
	
    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate(){
        return this.date;
    }

}
