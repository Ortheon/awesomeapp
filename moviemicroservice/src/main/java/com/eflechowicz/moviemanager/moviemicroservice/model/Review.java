package com.eflechowicz.moviemanager.moviemicroservice.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Review {


    @Id
    private String id;
    @Size(min=3, max=50) @Pattern(regexp = "^[a-zA-Z]+$")
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
