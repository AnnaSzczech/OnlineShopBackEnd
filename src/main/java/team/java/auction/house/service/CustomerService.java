package team.java.auction.house.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.java.auction.house.domain.CustomerEntity;
import team.java.auction.house.repository.CustomerRepository;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Optional<CustomerEntity> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public void save(CustomerEntity customer) {
        customerRepository.save(customer);
    }
}
