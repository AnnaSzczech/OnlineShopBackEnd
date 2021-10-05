package team.java.auction.house.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.java.auction.house.domain.SalesInvoiceEntity;
import team.java.auction.house.dto.ErrorMessage;
import team.java.auction.house.dto.Response;
import team.java.auction.house.dto.SalesInvoiceDTO;
import team.java.auction.house.service.SalesInvoiceService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Optional;

@RestController
@RequestMapping(path = "/salesInvoice")
public class SalesInvoiceController extends BasicResponse {

    private static final Logger logger = LogManager.getLogger(SalesInvoiceController.class);

    @Autowired
    private SalesInvoiceService salesInvoiceService;

    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping(value = "/{number}")
    public Response<SalesInvoiceDTO> getSalesInvoice(@PathVariable("number") String invoiceNumber) {
        Optional<SalesInvoiceEntity> salesInvoice = salesInvoiceService.findBySalesInvoiceNumber(invoiceNumber);
        return (salesInvoice.isPresent()) ? createOkResponse(modelMapper.map(salesInvoice.get(), SalesInvoiceDTO.class)) : createNoDataResponse();
    }

    @PostMapping
    public Response<SalesInvoiceDTO> createSalesInvoice(@RequestBody SalesInvoiceDTO salesInvoiceDTO) {
        Optional<SalesInvoiceEntity> salesInvoice = salesInvoiceService.findBySalesInvoiceNumber(salesInvoiceDTO.getSalesInvoiceNumber());
        if (salesInvoice.isPresent()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
            return createErrorResponse(new ErrorMessage(409, "Podana faktura już istnieje!", date));
        }
        salesInvoiceService.save(modelMapper.map(salesInvoiceDTO, SalesInvoiceEntity.class));
        return createOkResponse();
    }
}