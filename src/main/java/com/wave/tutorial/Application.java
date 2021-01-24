package com.wave.tutorial;

import com.wave.tutorial.customer.compositepartitionclustering.CustomerCompositePartitionAndClustering;
import com.wave.tutorial.customer.compositepartitionclustering.CustomerCompositePartitionAndClusteringKey;
import com.wave.tutorial.customer.compositepartitionclustering.CustomerCompositePartitionAndClusteringRepository;
import com.wave.tutorial.customer.simple.Customer;
import com.wave.tutorial.customer.simple.SimpleCustomerRepository;
import com.wave.tutorial.customer.simplepartitionclustering.CustomerSimplePartitionAndClustering;
import com.wave.tutorial.customer.simplepartitionclustering.CustomerSimplePartitionAndClusteringKey;
import com.wave.tutorial.customer.simplepartitionclustering.CustomerSimplePartitionAndClusteringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private SimpleCustomerRepository simpleCustomerRepository;

    @Autowired
    private CustomerSimplePartitionAndClusteringRepository customerSimplePartitionAndClusteringRepository;

    @Autowired
    private CustomerCompositePartitionAndClusteringRepository customerCompositePartitionAndClusteringRepository;

    public static void main(final String args[]) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {


        simpleCustomerRepository.insert(new Customer(1, "Atlas", 25, "London", "Berks", "England"));

        Customer customer = simpleCustomerRepository.findByCustomerId(1);

        System.out.println(customer);

        Optional<Customer> customerOptional = simpleCustomerRepository.findById(1);

        System.out.println(customerOptional.get());

        CustomerSimplePartitionAndClusteringKey customerSimplePartitionAndClusteringKey
                = new CustomerSimplePartitionAndClusteringKey(1, "Amit", 25);

        CustomerSimplePartitionAndClustering customerSimplePartitionAndClustering =
                new CustomerSimplePartitionAndClustering(customerSimplePartitionAndClusteringKey, "London", "Berks", "England");
        customerSimplePartitionAndClusteringRepository.insert(customerSimplePartitionAndClustering);

        System.out.println(customerSimplePartitionAndClusteringRepository.findByKeyCustomerId(1));

        CustomerCompositePartitionAndClusteringKey customerCompositePartitionAndClusteringKey
                = new CustomerCompositePartitionAndClusteringKey(1, "Amit", 25);

        CustomerCompositePartitionAndClustering customerCompositePartitionAndClustering =
                new CustomerCompositePartitionAndClustering(customerCompositePartitionAndClusteringKey, "London", "Berks", "England");
        customerCompositePartitionAndClusteringRepository.insert(customerCompositePartitionAndClustering);

        System.out.println(customerCompositePartitionAndClusteringRepository.findByKeyCustomerIdAndKeyName(1, "Amit"));

        System.exit(1);
    }
}
