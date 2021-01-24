package com.wave.tutorial.customer.simplepartitionclustering;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerSimplePartitionAndClusteringRepository extends CassandraRepository<CustomerSimplePartitionAndClustering, CustomerSimplePartitionAndClusteringKey> {

    CustomerSimplePartitionAndClustering findByKeyCustomerId(final Integer id);

}
