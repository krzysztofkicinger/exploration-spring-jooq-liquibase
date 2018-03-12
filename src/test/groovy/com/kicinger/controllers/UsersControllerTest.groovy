package com.kicinger.controllers

import com.kicinger.services.UsersService
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Subject

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UsersControllerTest extends Specification {

    @Mock
    UsersService usersService

    @Subject
    @InjectMocks
    UsersController usersController

    @Test
    def "should properly initialize the context of the app"() {
        expect:
        usersController != null
    }

}
