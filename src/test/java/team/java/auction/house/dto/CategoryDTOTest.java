package team.java.auction.house.dto;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import team.java.auction.house.domain.CategoryEntity;

import static org.junit.Assert.assertEquals;

public class CategoryDTOTest {

    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertCategoryEntityToCategoryDto_thenCorrect() {
        CategoryEntity category = new CategoryEntity();
        category.setId(123L);
        category.setName("Bieganie");

        CategoryDTO categoryDTO = modelMapper.map(category,CategoryDTO.class);
        assertEquals(category.getId(), categoryDTO.getId());
        assertEquals(category.getName(), categoryDTO.getName());
    }

    @Test
    public void whenConvertCategoryDTOToCategoryEntity_thenCorrect() {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(123L);
        categoryDTO.setName("Sporty zimowe");

        CategoryEntity category = modelMapper.map(categoryDTO, CategoryEntity.class);
        assertEquals(category.getId(), categoryDTO.getId());
        assertEquals(category.getName(), categoryDTO.getName());
    }
}
