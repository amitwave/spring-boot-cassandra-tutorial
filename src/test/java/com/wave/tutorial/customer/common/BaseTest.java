package com.wave.tutorial.customer.common;

import com.wave.tutorial.customer.EmbeddedCassandra;

public abstract class BaseTest {

    protected static EmbeddedCassandra embeddedCassandra = new EmbeddedCassandra();
}
