package com.wave.tutorial.customer.simplepartitionclustering;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@AllArgsConstructor
@Table("customer_simple_partition_clustering")
public class CustomerSimplePartitionAndClustering {

    @PrimaryKey
    private CustomerSimplePartitionAndClusteringKey key;

    @Column("city")
    private String city;

    @Column("state")
    private String state;

    @Column("country")
    private String country;
}
