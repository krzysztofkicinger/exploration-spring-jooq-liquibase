/*
 * This file is generated by jOOQ.
*/
package com.kicinger.domain;


import com.kicinger.domain.tables.Person;
import com.kicinger.domain.tables.State;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.person</code>.
     */
    public static final Person PERSON = com.kicinger.domain.tables.Person.PERSON;

    /**
     * The table <code>public.state</code>.
     */
    public static final State STATE = com.kicinger.domain.tables.State.STATE;
}