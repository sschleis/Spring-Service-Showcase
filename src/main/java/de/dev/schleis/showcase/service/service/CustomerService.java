package de.dev.schleis.showcase.service.service;

import de.dev.schleis.showcase.service.persistence.repository.CustomerRepository;
import de.dev.schleis.showcase.service.persistence.unit.Customer;
import org.springframework.web.bind.annotation.*;

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
        return customerRepository.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Customer findCustomer(@PathVariable("id") final Long id) {
        return customerRepository.findById(id);
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
