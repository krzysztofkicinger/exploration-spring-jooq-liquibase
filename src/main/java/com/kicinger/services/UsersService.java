package com.kicinger.services;

import com.kicinger.domain.tables.pojos.User;
import com.kicinger.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Flux<User> getUsers() {
        return Flux.fromIterable(usersRepository.getUsers());
    }

}
