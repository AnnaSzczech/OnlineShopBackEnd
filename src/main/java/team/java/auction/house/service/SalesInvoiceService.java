package team.java.auction.house.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.java.auction.house.domain.SalesInvoiceEntity;
import team.java.auction.house.repository.SalesInvoiceRepository;

import java.util.Optional;

@Service
public class SalesInvoiceService {
    @Autowired
    private SalesInvoiceRepository salesInvoiceRepository;

    public Optional<SalesInvoiceEntity> findById(Long id) {
        return salesInvoiceRepository.findById(id);
    }

    public Optional<SalesInvoiceEntity> findBySalesInvoiceNumber(String name) {
        return salesInvoiceRepository.findBySalesInvoiceNumber(name);
    }

    public void save(SalesInvoiceEntity salesInvoice) {
        salesInvoice.getSalesInvoiceItems().forEach((si) -> si.setSalesInvoice(salesInvoice));
        salesInvoiceRepository.save(salesInvoice);
    }

    public void delete(SalesInvoiceEntity salesInvoiceItem) {
        salesInvoiceRepository.delete(salesInvoiceItem);
    }
}
