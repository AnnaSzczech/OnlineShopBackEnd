package team.java.auction.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.java.auction.house.domain.CustomerEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    @Override
    CustomerEntity save(CustomerEntity order);

    @Override
    List<CustomerEntity> findAll();

    @Override
    Optional<CustomerEntity> findById(Long id);
}
