package com.wave.tutorial.customer.simplepartitionclustering;


import com.wave.tutorial.CassandraConfig;
import com.wave.tutorial.customer.common.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = CassandraConfig.class)
@SpringBootTest
public class SimplePartitionCustomerRepositoryTest extends BaseTest {

    @Autowired
    private CustomerSimplePartitionAndClusteringRepository customerSimplePartitionAndClusteringRepository;

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
