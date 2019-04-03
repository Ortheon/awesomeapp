package com.reviewapproverapp.reviews.controller;

import com.reviewapproverapp.reviews.model.Review;
import org.springframework.web.bind.annotation.*;
import utils.Sanitizer;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/sanitize")
public class SanitizerController {
    @PostMapping(value = "/review")
    public Review sanitizeReview(@Valid @RequestBody Review entity) {
        System.out.println("sanityzacja");
        entity.setContent(Sanitizer.sanitizer(entity.getContent()));
        entity.setApproval(true);
        return entity;
    }
    @GetMapping(value = "/")
    public double sanitizeReview() {

        return 2.0;
    }
}