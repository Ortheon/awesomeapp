package com.reviewapproverapp.reviews.model;

public class Review {

    private String id;
    private String title;
    private String content;
    private boolean approval = false;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public boolean isApproval() {
        return approval;
    }
    public void setApproval(boolean approval) {
        this.approval = approval;
    }
}
