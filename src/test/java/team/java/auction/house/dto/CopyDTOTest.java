package team.java.auction.house.dto;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import team.java.auction.house.domain.CopyEntity;
import team.java.auction.house.domain.ProductEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CopyDTOTest {

    private final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertCopyEntityToCopyDto_thenCorrect() {
        CopyEntity copy = new CopyEntity();
        copy.setId(123L);
        copy.setProduct(new ProductEntity());
        copy.setProductCode("ABC-123");
        copy.setSold(false);
        CopyDTO copyDTO = modelMapper.map(copy, CopyDTO.class);
        assertEquals(copy.getId(), copyDTO.getId());
        assertEquals(copy.getProduct(), copyDTO.getProduct());
        assertEquals(copy.getProductCode(), copyDTO.getProductCode());
        assertEquals(copy.isSold(), copyDTO.isSold());
    }

    @Test
    public void whenConvertCopyEntityToCopyDtoWithWrongProduct_thenIncorrect() {
        CopyEntity copy = new CopyEntity();
        copy.setId(123L);
        copy.setProduct(new ProductEntity());
        copy.setProductCode("ABC-123");
        copy.setSold(false);
        CopyDTO copyDTO = modelMapper.map(copy, CopyDTO.class);
        copyDTO.setProduct(new ProductDTO());
        assertEquals(copy.getId(), copyDTO.getId());
        assertNotEquals(copy.getProduct(), copyDTO.getProduct());
        assertEquals(copy.getProductCode(), copyDTO.getProductCode());
        assertEquals(copy.isSold(), copyDTO.isSold());
    }

    @Test
    public void whenConvertCopyDTOToCopyEntity_thenCorrect() {
        CopyDTO copyDTO = new CopyDTO();
        copyDTO.setId(123L);
        copyDTO.setProductCode("CBA-321");
        copyDTO.setProduct(new ProductDTO());

        CopyEntity copy = modelMapper.map(copyDTO, CopyEntity.class);
        assertEquals(copy.getId(), copyDTO.getId());
        assertEquals(copy.getProductCode(), copyDTO.getProductCode());
        assertEquals(copy.getProduct(), copyDTO.getProduct());

    }
}
