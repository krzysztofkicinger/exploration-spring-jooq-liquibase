package com.kicinger.services;

import com.kicinger.domain.tables.pojos.Person;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.kicinger.domain.tables.Person.PERSON;

@Service
@Transactional
public class PersonService {

    private final DSLContext create;

    @Autowired
    public PersonService(DSLContext create) {
        this.create = create;
    }

    public List<Person> fetchPojos() {
        return this.create.select()
                .from(PERSON)
                .fetchInto(Person.class);
    }

}
