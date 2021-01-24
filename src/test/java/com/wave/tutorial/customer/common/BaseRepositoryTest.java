package com.wave.tutorial.customer.common;


import com.wave.tutorial.CassandraConfig;
import com.wave.tutorial.customer.EmbeddedCassandra;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = CassandraConfig.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseRepositoryTest extends BaseTest{

    @AfterAll
    public void afterClass() {
        embeddedCassandra.stop();
    }

}
