package team.java.auction.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.java.auction.house.domain.OrderEntity;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    @Override
    OrderEntity save(OrderEntity order);

    @Override
    List<OrderEntity> findAll();

    @Override
    Optional<OrderEntity> findById(Long id);
}