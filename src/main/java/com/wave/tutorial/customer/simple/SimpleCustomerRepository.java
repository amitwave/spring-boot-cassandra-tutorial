package com.wave.tutorial.customer.simple;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimpleCustomerRepository extends CassandraRepository<Customer, Integer> {

    Customer findByCustomerId(final Integer id);

    @Query(allowFiltering = true)
    List<Customer> findByName(final String ame);
}
