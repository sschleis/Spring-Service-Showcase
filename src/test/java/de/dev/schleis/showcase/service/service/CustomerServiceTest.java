package de.dev.schleis.showcase.service.service;

import de.dev.schleis.showcase.service.persistence.repository.CustomerRepository;
import de.dev.schleis.showcase.service.persistence.unit.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService underTest;

    @Before
    public void init() {
        customerRepository.deleteAll();

        customerRepository.save(Customer.builder()
                .firstname("Luke")
                .lastname("Skywalker")
                .birthdate(new Date())
                .build());
    }

    @Test
    public void testFindAll() {
        final List<Customer> results = underTest.findAllCustomers();

        assertThat(results).isNotNull().isNotEmpty().hasSize(1);
    }

}