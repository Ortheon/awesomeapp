package com.eflechowicz.moviemanager.moviemicroservice.client;

import com.eflechowicz.moviemanager.moviemicroservice.model.Review;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "sanitize-service")
public interface SanitizeClient {

    @PostMapping("/sanitize/review")
    String sanitizeReview(@Valid @RequestBody Review entity);
}
