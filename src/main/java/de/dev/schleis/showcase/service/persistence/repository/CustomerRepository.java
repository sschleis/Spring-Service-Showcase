package de.dev.schleis.showcase.service.persistence.repository;

import de.dev.schleis.showcase.service.persistence.unit.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findById(final Long id);
}
