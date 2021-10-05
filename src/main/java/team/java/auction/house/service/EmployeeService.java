package team.java.auction.house.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.java.auction.house.domain.EmployeeEntity;
import team.java.auction.house.repository.EmployeeRepository;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<EmployeeEntity> findEmployeeById(Long id) {

        return employeeRepository.findById(id);
    }
}