package com.wave.tutorial.customer.simplepartitionclustering;


import com.wave.tutorial.CassandraConfig;
import com.wave.tutorial.customer.EmbeddedCassandra;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = CassandraConfig.class)
@SpringBootTest
public class SimplePartitionCustomerRepositoryTest {


    private static EmbeddedCassandra embeddedCassandra = new EmbeddedCassandra();
    @Autowired
    private CustomerSimplePartitionAndClusteringRepository customerSimplePartitionAndClusteringRepository;

    @AfterAll
    public static void afterClass() {
        // embeddedCassandra.stop();
    }

    @Test
    public void shouldSaveAndRetrieveCustomer() {
        CustomerSimplePartitionAndClusteringKey customerSimplePartitionAndClusteringKey
                = new CustomerSimplePartitionAndClusteringKey(1, "Amit", 24);

        CustomerSimplePartitionAndClustering customer =
                new CustomerSimplePartitionAndClustering(customerSimplePartitionAndClusteringKey, "London", "Berks", "England");
        customerSimplePartitionAndClusteringRepository.insert(customer);


        CustomerSimplePartitionAndClustering expectedCustomer = customerSimplePartitionAndClusteringRepository.findByKeyCustomerId(1);

        assertEquals(expectedCustomer, customer, "Unexpected customer");

    }


}
