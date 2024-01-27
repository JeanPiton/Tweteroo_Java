package com.tweteroojava.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tweteroojava.api.dtos.TweetDTO;
import com.tweteroojava.api.models.TweetModel;
import com.tweteroojava.api.models.UserModel;
import com.tweteroojava.api.repositories.TweetRepository;
import com.tweteroojava.api.repositories.UserRepository;

@Service
public class TweetService {
    
    final TweetRepository tweetRepository;
    final UserRepository userRepository;

    TweetService(TweetRepository tweetRepository, UserRepository userRepository){
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    public Optional<TweetModel> save(TweetDTO dto){
        Optional<UserModel> user = userRepository.findById(dto.getUserId());
        if(!user.isPresent()){
            return Optional.empty();
        }
        TweetModel tweet = new TweetModel(dto,user.get());
        return Optional.of(tweetRepository.save(tweet));
    }

    public List<TweetModel> findAll(){
        return tweetRepository.findAll();
    }
}
