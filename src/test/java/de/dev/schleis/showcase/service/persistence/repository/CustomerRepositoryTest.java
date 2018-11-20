package de.dev.schleis.showcase.service.persistence.repository;

import de.dev.schleis.showcase.service.persistence.unit.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository underTest;

    @Test
    public void testSave() {
        final Customer result = underTest.save(Customer.builder()
                .firstname("Luke")
                .lastname("Skywalker")
                .birthdate(new Date())
                .build());

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotNull().isGreaterThan(0);
    }
}