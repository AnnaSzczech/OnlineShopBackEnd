package team.java.auction.house.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.java.auction.house.domain.ProducerEntity;
import team.java.auction.house.dto.ErrorMessage;
import team.java.auction.house.dto.ProducerDTO;
import team.java.auction.house.dto.Response;
import team.java.auction.house.service.ProducerService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/producer")
public class ProducerController extends BasicResponse {

    @Autowired
    private ProducerService producerService;

    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping(value = "/all")
    public Response<List<ProducerDTO>> getCategories() {
        List<ProducerEntity> producers = producerService.findAll();
        List<ProducerDTO> data = new ArrayList<>();
        producers.forEach(producer -> data.add(modelMapper.map(producer, ProducerDTO.class)));
        return data.isEmpty() ? createNoDataResponse() : createOkResponse(data);
    }

    @GetMapping(value = "/{id}")
    public Response<ProducerDTO> getCategory(@PathVariable("id") Long producerId) {
        Optional<ProducerEntity> producer = producerService.findById(producerId);
        return (producer.isPresent()) ? createOkResponse(modelMapper.map(producer.get(), ProducerDTO.class)) : createNoDataResponse();
    }

    @PostMapping
    public Response<ProducerDTO> createCategory(@RequestBody ProducerDTO producerDTO) {
        Optional<ProducerEntity> producer = producerService.findByName(producerDTO.getName());
        if (producer.isPresent()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
            return createErrorResponse(new ErrorMessage(409, "Podany producent już istnieje!", date));
        }
        producerService.save(modelMapper.map(producerDTO, ProducerEntity.class));
        return createOkResponse();
    }
}