package team.java.auction.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.java.auction.house.domain.CopyEntity;
import team.java.auction.house.domain.ProducerEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CopyRepository extends JpaRepository<CopyEntity, Long> {

    @Override
    CopyEntity save(CopyEntity copy);

    @Override
    List<CopyEntity> findAll();

    @Override
    Optional<CopyEntity> findById(Long id);

    Optional<CopyEntity> findByProductCode(String productCode);

    List<ProducerEntity> findAllByIsSold(boolean isSold);
}
