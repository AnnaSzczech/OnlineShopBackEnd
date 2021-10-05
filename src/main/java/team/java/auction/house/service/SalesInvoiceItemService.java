package team.java.auction.house.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.java.auction.house.domain.SalesInvoiceItemEntity;
import team.java.auction.house.repository.SalesInvoiceItemRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SalesInvoiceItemService {
    @Autowired
    private SalesInvoiceItemRepository salesInvoiceItemRepository;

    public Optional<SalesInvoiceItemEntity> findById(Long id) {
        return salesInvoiceItemRepository.findById(id);
    }

    public List<SalesInvoiceItemEntity> findBySalesInvoiceId(Long salesInvoiceId) {
        return salesInvoiceItemRepository.allItemsForInvoice(salesInvoiceId);
    }


    public void save(SalesInvoiceItemEntity salesInvoiceItem) {
        salesInvoiceItemRepository.save(salesInvoiceItem);
    }

    public void delete(SalesInvoiceItemEntity salesInvoiceItem) {
        salesInvoiceItemRepository.delete(salesInvoiceItem);
    }
}
