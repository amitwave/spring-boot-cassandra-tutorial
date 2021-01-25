package com.wave.tutorial.customer.simple;

import com.wave.tutorial.CassandraConfig;
import com.wave.tutorial.customer.common.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.data.cassandra.core.query.Criteria.where;

@SpringBootTest
@ContextConfiguration(classes = CassandraConfig.class)
public class SimpleCustomerRepositoryTest extends BaseTest {

    @Autowired
    private SimpleCustomerRepository simpleCustomerRepository;


    // Just to demothat one can use CassandraTemlate too
    @Autowired
    CassandraTemplate cassandraTemplate;

    @Test
    public void shouldCreateAndRetrieveCustomer() {
        Customer customer = new Customer(1, "Atlas", 26, "London", "Berks", "England");
        simpleCustomerRepository.insert(customer);

        Customer expectedCustomer = simpleCustomerRepository.findByCustomerId(1);

        assertEquals(expectedCustomer, customer, "Unexpected customer");
    }

    @Test
    public void shouldCreateAndRetrieveCustomerUsingCassandraTemplateUsingQuery() {
        Customer customer = new Customer(1, "Atlas", 26, "London", "Berks", "England");
        cassandraTemplate.insert(customer);

        Query query = Query.query(where("customerId").is(1));

        Customer expectedCustomer = cassandraTemplate.selectOne(query, Customer.class);

        assertEquals(expectedCustomer, customer, "Unexpected customer");

        expectedCustomer = cassandraTemplate.selectOne("select * from customer_simple where customerId=1", Customer.class);

        assertEquals(expectedCustomer, customer, "Unexpected customer");

    }

    @Test
    public void shouldCreateAndUpdateRetrieveCustomer() {
        Customer customer = new Customer(1, "Atlas", 26, "London", "Berks", "England");
        simpleCustomerRepository.insert(customer);

        Customer expectedCustomer = simpleCustomerRepository.findByCustomerId(1);

        assertEquals(expectedCustomer, customer, "Unexpected customer");
        assertEquals(expectedCustomer.getAge(), 26, "Unexpected age");

        customer = new Customer(1, "Atlas", 50, "London", "Berks", "England");

        // update
        simpleCustomerRepository.save(customer);
        expectedCustomer = simpleCustomerRepository.findByCustomerId(1);

        assertEquals(expectedCustomer, customer, "Unexpected customer");
        assertEquals(expectedCustomer.getAge(), 50, "Unexpected age");
    }

    @Test
    public void shouldCreateAndDeleteCustomer() {
        Customer customer = new Customer(1, "Atlas", 26, "London", "Berks", "England");
        simpleCustomerRepository.insert(customer);

        Customer expectedCustomer = simpleCustomerRepository.findByCustomerId(1);

        assertEquals(expectedCustomer, customer, "Unexpected customer");
        assertEquals(expectedCustomer.getAge(), 26, "Unexpected age");

        customer = new Customer(1, "Atlas", 50, "London", "Berks", "England");

        // delete
        simpleCustomerRepository.delete(customer);
        expectedCustomer = simpleCustomerRepository.findByCustomerId(1);

        assertNull(expectedCustomer, "Unexpected customer");
    }

    @Test
    public void shouldSaveAndRetrieveCustomerByName() {
        Customer customer = new Customer(1, "Atlas", 26, "London", "Berks", "England");
        simpleCustomerRepository.insert(customer);

        List<Customer> expectedCustomer = simpleCustomerRepository.findByName("Atlas");

        assertEquals(expectedCustomer.get(0), customer, "Unexpected customer");
    }

    @AfterEach
    public void afterEach(){
        simpleCustomerRepository.deleteAll();
    }

}
