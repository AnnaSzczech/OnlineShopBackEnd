package team.java.auction.house.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.java.auction.house.domain.SalesInvoiceItemEntity;
import team.java.auction.house.dto.ErrorMessage;
import team.java.auction.house.dto.Response;
import team.java.auction.house.dto.SalesInvoiceDTO;
import team.java.auction.house.dto.SalesInvoiceItemDTO;
import team.java.auction.house.service.SalesInvoiceItemService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/salesInvoiceItem")
public class SalesInvoiceItemController extends BasicResponse {

    @Autowired
    private SalesInvoiceItemService salesInvoiceItemService;

    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping(value = "/{salesInvoiceId}")
    public Response<List<SalesInvoiceItemDTO>> getAllItemsForInvoice(@PathVariable(name = "salesInvoiceId") Long salesInvoiceId) {
        List<SalesInvoiceItemEntity> salesInvoiceItems = salesInvoiceItemService.findBySalesInvoiceId(salesInvoiceId);
        List<SalesInvoiceItemDTO> data = new ArrayList<>();
        salesInvoiceItems.forEach(salesInvoiceItem -> data.add(modelMapper.map(salesInvoiceItem, SalesInvoiceItemDTO.class)));
        return (!salesInvoiceItems.isEmpty()) ? createOkResponse(data) : createNoDataResponse();
    }

    @PostMapping
    public Response<SalesInvoiceDTO> createSalesInvoice(@RequestBody SalesInvoiceItemDTO salesInvoiceItemDTO) {
        Optional<SalesInvoiceItemEntity> salesInvoiceItem = salesInvoiceItemService.findById(salesInvoiceItemDTO.getId());
        if (salesInvoiceItem.isPresent()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
            return createErrorResponse(new ErrorMessage(409, "Podany elemnt faktury już istnieje!", date));
        }
        salesInvoiceItemService.save(modelMapper.map(salesInvoiceItemDTO, SalesInvoiceItemEntity.class));
        return createOkResponse();
    }
}