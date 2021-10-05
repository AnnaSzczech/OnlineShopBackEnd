package team.java.auction.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.java.auction.house.domain.CategoryProducerEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CategoryProducerRepository  extends JpaRepository<CategoryProducerEntity, Long> {
    @Override
    CategoryProducerEntity save(CategoryProducerEntity order);

    @Override
    List<CategoryProducerEntity> findAll();

    @Override
    Optional<CategoryProducerEntity> findById(Long id);
}
