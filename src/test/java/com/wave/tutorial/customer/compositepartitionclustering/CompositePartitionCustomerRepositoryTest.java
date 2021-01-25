package com.wave.tutorial.customer.compositepartitionclustering;


import com.wave.tutorial.CassandraConfig;
import com.wave.tutorial.customer.EmbeddedCassandra;
import com.wave.tutorial.customer.common.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ContextConfiguration(classes = CassandraConfig.class)
public class CompositePartitionCustomerRepositoryTest extends BaseTest {

    @Autowired
    private CustomerCompositePartitionAndClusteringRepository repository;


    @Test
    public void shouldSaveAndRetrieveCustomer() {

        CustomerCompositePartitionAndClusteringKey key
                = new CustomerCompositePartitionAndClusteringKey(1, "Amit", 25);

        CustomerCompositePartitionAndClustering customer =
                new CustomerCompositePartitionAndClustering(key, "London", "Berks", "England");
        repository.insert(customer);

        CustomerCompositePartitionAndClustering expectedCustomer = repository.findByKeyCustomerIdAndKeyName(1, "Amit");

        assertEquals(expectedCustomer, customer, "Unexpected customer");
    }


}
