package com.wave.tutorial.customer.simplepartitionclustering;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.io.Serializable;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
@PrimaryKeyClass
public class CustomerSimplePartitionAndClusteringKey implements Serializable {

    @PrimaryKeyColumn(name = "customer_id", type = PARTITIONED)
    private Integer customerId;

    @PrimaryKeyColumn(name = "name")
    private String name;

    @PrimaryKeyColumn("age")
    private Integer age;

}
