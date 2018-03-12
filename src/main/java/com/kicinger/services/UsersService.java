package com.kicinger.services;

import com.kicinger.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class UsersService {


    public Flux<User> getUsernames() {
        return Flux.just(new User("johnsmith"), new User("philcollins"), new User("sting"));
    }

}
