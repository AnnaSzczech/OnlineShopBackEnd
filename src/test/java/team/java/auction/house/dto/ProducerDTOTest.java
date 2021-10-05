package team.java.auction.house.dto;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import team.java.auction.house.domain.CategoryEntity;
import team.java.auction.house.domain.ProducerEntity;
import team.java.auction.house.domain.ProductEntity;

import static org.junit.Assert.assertEquals;

public class ProducerDTOTest {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertProducerEntityToProducerDto_thenCorrect() {
        ProducerEntity producer = new ProducerEntity();
        producer.setId(123L);
        producer.setName("Nike");

        ProducerDTO producerDTO = modelMapper.map(producer,ProducerDTO.class);
        assertEquals(producer.getId(), producerDTO.getId());
        assertEquals(producer.getName(), producerDTO.getName());
    }

    @Test
    public void whenConvertProducerDTOToProducerEntity_thenCorrect() {
        ProducerDTO producerDTO = new ProducerDTO();
        producerDTO.builder().id(123L).name("Puma").build();

        ProducerEntity producer = modelMapper.map(producerDTO, ProducerEntity.class);
        assertEquals(producer.getId(), producerDTO.getId());
        assertEquals(producer.getName(), producerDTO.getName());
    }
}
