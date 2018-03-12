package com.kicinger.controllers

import com.kicinger.User
import com.kicinger.services.UsersService
import org.junit.Test
import org.mockito.InjectMocks
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Flux
import spock.lang.Specification
import spock.lang.Subject

import java.util.stream.Stream

import static org.mockito.Mockito.when

@WebFluxTest(UsersController.class)
class UsersControllerTest extends Specification {

    public static final User redUser = new User(username: "reduser")
    public static final User blueUser = new User(username: "blueuser")

    @Autowired
    WebTestClient webClient

    @MockBean
    UsersService usersService

    @Subject
    @InjectMocks
    UsersController usersController

    @Test
    def "should properly initialize the context of the app"() {

        given:
        when(usersService.getUsernames()).thenReturn(Flux.just(redUser, blueUser))

        when:
        def response = webClient.get()
                .uri("/usernames")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()

        then:
        response
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBodyList(User.class)
                .hasSize(2)
                .contains(redUser, blueUser)

    }

}
