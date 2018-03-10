/*
 * This file is generated by jOOQ.
*/
package com.kicinger.domain;


import com.kicinger.domain.tables.Person;
import com.kicinger.domain.tables.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Public extends SchemaImpl {

    private static final long serialVersionUID = -1016457808;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.person</code>.
     */
    public final Person PERSON = com.kicinger.domain.tables.Person.PERSON;

    /**
     * The table <code>public.state</code>.
     */
    public final State STATE = com.kicinger.domain.tables.State.STATE;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        List result = new ArrayList();
        result.addAll(getSequences0());
        return result;
    }

    private final List<Sequence<?>> getSequences0() {
        return Arrays.<Sequence<?>>asList(
            Sequences.PERSON_ID_SEQ);
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Person.PERSON,
            State.STATE);
    }
}
