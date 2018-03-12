package com.kicinger.services

import com.kicinger.domain.tables.pojos.User
import com.kicinger.repositories.UsersRepository
import spock.lang.Specification
import spock.lang.Subject

class UsersServiceTest extends Specification {

    public static final User redUser = new User(id: 1, firstname: 'John', lastname: 'Smith')
    public static final User blueUser = new User(id: 2, firstname: 'Michael', lastname: 'Brown')

    UsersRepository usersRepository

    @Subject
    UsersService usersService

    void setup() {
        usersRepository = Mock(UsersRepository.class)
        usersService = new UsersService(usersRepository)
    }

    def "should return true"() {
        given:
        usersRepository.getUsers() >> Arrays.asList(redUser, blueUser)

        expect:
        usersService.getUsers() != null
    }

}
