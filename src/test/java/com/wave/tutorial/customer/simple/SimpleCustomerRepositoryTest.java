package com.wave.tutorial.customer.simple;


import com.wave.tutorial.CassandraConfig;
import com.wave.tutorial.customer.EmbeddedCassandra;
import com.wave.tutorial.customer.common.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = CassandraConfig.class)
public class SimpleCustomerRepositoryTest extends BaseTest {

    @Autowired
    private SimpleCustomerRepository simpleCustomerRepository;

    @Test
    public void shouldSaveAndRetrieveCustomer() {
        Customer customer = new Customer(1, "Atlas", 26, "London", "Berks", "England");
        simpleCustomerRepository.insert(customer);

        Customer expectedCustomer = simpleCustomerRepository.findByCustomerId(1);

        assertEquals(expectedCustomer, customer, "Unexpected customer");
    }


}
