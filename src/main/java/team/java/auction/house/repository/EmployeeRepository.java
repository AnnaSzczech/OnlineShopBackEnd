package team.java.auction.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.java.auction.house.domain.EmployeeEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    @Override
    EmployeeEntity save(EmployeeEntity order);

    @Override
    List<EmployeeEntity> findAll();

    @Override
    Optional<EmployeeEntity> findById(Long id);
}