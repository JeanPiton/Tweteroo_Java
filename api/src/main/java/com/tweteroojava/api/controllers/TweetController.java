package com.tweteroojava.api.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroojava.api.dtos.TweetDTO;
import com.tweteroojava.api.models.TweetModel;
import com.tweteroojava.api.services.TweetService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/tweets")
public class TweetController {
    
    final TweetService tweetService;

    TweetController(TweetService tweetService){
        this.tweetService = tweetService;
    }

    @PostMapping
    public ResponseEntity<Object> createTweet(@RequestBody @Valid TweetDTO body) {
        Optional<TweetModel> tweet = tweetService.save(body);
        if(!tweet.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User must exist");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(tweet);
    }
    
}
