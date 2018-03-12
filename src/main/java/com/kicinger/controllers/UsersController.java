package com.kicinger.controllers;

import com.kicinger.User;
import com.kicinger.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class UsersController {

    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(path = "/usernames", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_EVENT_STREAM_VALUE })
    public Flux<User> getUsernames() {
        return usersService.getUsernames();
    }


}
