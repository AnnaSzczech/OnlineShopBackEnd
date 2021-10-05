package team.java.auction.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team.java.auction.house.domain.SalesInvoiceEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalesInvoiceRepository extends JpaRepository<SalesInvoiceEntity, Long> {

    @Override
    SalesInvoiceEntity save(SalesInvoiceEntity producer);

    @Override
    List<SalesInvoiceEntity> findAll();

    @Override
    Optional<SalesInvoiceEntity> findById(Long id);

    Optional<SalesInvoiceEntity> findBySalesInvoiceNumber(String name);
}