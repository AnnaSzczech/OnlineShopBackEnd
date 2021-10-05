package team.java.auction.house.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.java.auction.house.domain.CopyEntity;
import team.java.auction.house.dto.CopyDTO;
import team.java.auction.house.dto.ErrorMessage;
import team.java.auction.house.dto.Response;
import team.java.auction.house.service.CopyService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Optional;

@RestController
@RequestMapping(path = "/copy")
public class CopyController extends BasicResponse {

    @Autowired
    private CopyService copyService;

    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping(value = "/{id}")
    public Response<CopyDTO> getCopy(@PathVariable("id") Long copyId) {
        Optional<CopyEntity> copy = copyService.findCopyById(copyId);
        return (copy.isPresent()) ? createOkResponse(modelMapper.map(copy.get(), CopyDTO.class)) : createNoDataResponse();
    }

    @PostMapping
    public Response<CopyDTO> createCategory(@RequestBody CopyDTO copyDTO) {
        Optional<CopyEntity> copy = copyService.findCopyById(copyDTO.getId());
        if (copy.isPresent()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
            return createErrorResponse(new ErrorMessage(409, "Podany egzemplarz już istnieje!", date));
        }
        copyService.save(modelMapper.map(copyDTO, CopyEntity.class));
        return createOkResponse();
    }
}