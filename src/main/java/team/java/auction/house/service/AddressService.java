package team.java.auction.house.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.java.auction.house.domain.AddressEntity;
import team.java.auction.house.repository.AddressRepository;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Optional<AddressEntity> findCustomerById(Long id) {
        return addressRepository.findById(id);
    }

    public void save(AddressEntity address) {
        addressRepository.save(address);
    }
}