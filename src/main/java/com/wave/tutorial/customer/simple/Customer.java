package com.wave.tutorial.customer.simple;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

@Data
@AllArgsConstructor
@Table("customer_simple")
public class Customer {

    @PrimaryKey("customer_id")
    private Integer customerId;

    @Column("name")
    private String name;

    @Column("age")
    private Integer age;

    @Column("city")
    private String city;

    @Column("state")
    private String state;

    @Column("country")
    private String country;

}
