package com.kicinger.services

import spock.lang.Specification

class UsersServiceTest extends Specification {

    def "should return true"() {
        given:
        def userService = new UsersService();

        expect:
        userService != null
    }

}
