package team.java.auction.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.java.auction.house.domain.ContactEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
    @Override
    ContactEntity save(ContactEntity order);

    @Override
    List<ContactEntity> findAll();

    @Override
    Optional<ContactEntity> findById(Long id);


}