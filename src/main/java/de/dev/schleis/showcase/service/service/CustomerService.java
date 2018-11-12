package de.dev.schleis.showcase.service.service;

import de.dev.schleis.showcase.service.persistence.repository.CustomerRepository;
import de.dev.schleis.showcase.service.persistence.unit.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(final CustomerRepository customerRepository) {
        assert customerRepository != null;

        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public List<Customer> findAllCustomers() {
        System.out.println("Request");
        return customerRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Customer findCustomer(@PathVariable("id") final Long id) {
        return customerRepository.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody final Customer customer) {
        return customerRepository.save(customer);
    }

    @RequestMapping(value = "deleteAll", method = RequestMethod.DELETE)
    public void deleteAll() {
        customerRepository.deleteAll();
    }


}
