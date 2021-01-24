package com.wave.tutorial.customer;

import com.github.nosan.embedded.cassandra.Cassandra;
import com.github.nosan.embedded.cassandra.CassandraBuilder;

public class EmbeddedCassandra {

    private static Cassandra cassandra;

    public EmbeddedCassandra() {
        if (cassandra == null || !cassandra.isRunning()) {
            cassandra = this.startCassandra();
        }
    }

    private Cassandra startCassandra() {
        Cassandra cassandra = new CassandraBuilder()
                .addSystemProperty("cassandra.native_transport_port", 9142)
                .addSystemProperty("cassandra.jmx.local.port", 7199)
                .build();

        cassandra.start();

        return cassandra;
    }


    public void stop() {
        this.cassandra.stop();
    }

}
