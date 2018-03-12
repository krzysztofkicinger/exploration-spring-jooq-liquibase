package com.kicinger.repositories;

import com.kicinger.domain.tables.pojos.User;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.kicinger.domain.tables.User.USER;

@Repository
public class UsersRepository {

    private final DSLContext jooqContext;

    @Autowired
    public UsersRepository(DSLContext jooqContext) {
        this.jooqContext = jooqContext;
    }

    public List<User> getUsers() {
        return this.jooqContext.select()
                .from(USER)
                .fetch()
                .into(User.class);
    }

}
