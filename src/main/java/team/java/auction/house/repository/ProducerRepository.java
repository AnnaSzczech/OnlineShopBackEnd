package team.java.auction.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.java.auction.house.domain.ProducerEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProducerRepository extends JpaRepository<ProducerEntity, Long> {

    @Override
    ProducerEntity save(ProducerEntity producer);

    @Override
    List<ProducerEntity> findAll();

    @Override
    Optional<ProducerEntity> findById(Long id);

    Optional<ProducerEntity> findByName(String name);
}
