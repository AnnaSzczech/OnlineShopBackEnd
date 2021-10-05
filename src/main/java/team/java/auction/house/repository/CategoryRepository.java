package team.java.auction.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.java.auction.house.domain.CategoryEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @Override
    CategoryEntity save(CategoryEntity producer);

    @Override
    List<CategoryEntity> findAll();

    @Override
    Optional<CategoryEntity> findById(Long id);

    Optional<CategoryEntity> findByName(String name);
}
