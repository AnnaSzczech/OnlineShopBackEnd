package team.java.auction.house.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import team.java.auction.house.domain.SalesInvoiceItemEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalesInvoiceItemRepository extends JpaRepository<SalesInvoiceItemEntity, Long> {

    @Override
    SalesInvoiceItemEntity save(SalesInvoiceItemEntity producer);

    @Override
    List<SalesInvoiceItemEntity> findAll();

    @Override
    Optional<SalesInvoiceItemEntity> findById(Long id);

    @Query(nativeQuery = true)
    List<SalesInvoiceItemEntity> allItemsForInvoice(@Param("SALES_INVOICE_ID") Long salesInvoiceId);
}
