package team.java.auction.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.java.auction.house.domain.AddressEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    // possible mistake with order ?
    @Override
    AddressEntity save(AddressEntity order);


    @Override
    List<AddressEntity> findAll();

    @Override
    Optional<AddressEntity> findById(Long id);
}