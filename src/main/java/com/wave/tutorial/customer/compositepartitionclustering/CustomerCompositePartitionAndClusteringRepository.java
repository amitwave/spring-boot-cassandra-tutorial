package com.wave.tutorial.customer.compositepartitionclustering;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCompositePartitionAndClusteringRepository extends CassandraRepository<CustomerCompositePartitionAndClustering, CustomerCompositePartitionAndClusteringKey> {

    CustomerCompositePartitionAndClustering findByKeyCustomerIdAndKeyName(final Integer id, final String name);

}
