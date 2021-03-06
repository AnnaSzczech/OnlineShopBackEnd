package team.java.auction.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import team.java.auction.house.domain.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Override
    UserEntity save(UserEntity order);

    @Override
    List<UserEntity> findAll();

    @Override
    Optional<UserEntity> findById(Long id);

    @Query(nativeQuery = true)
    Optional<UserEntity> findByLogin(@Param("login") String login);
}