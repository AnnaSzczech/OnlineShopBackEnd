package team.java.auction.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.java.auction.house.domain.ProductEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Override
    ProductEntity save(ProductEntity order);

    @Override
    List<ProductEntity> findAll();

    @Override
    Optional<ProductEntity> findById(Long id);

//    @Query(nativeQuery = true)
//    List<ProductEntity> findByIds(@Param("PRODUCTS_IDS") List<Long> id);
}
